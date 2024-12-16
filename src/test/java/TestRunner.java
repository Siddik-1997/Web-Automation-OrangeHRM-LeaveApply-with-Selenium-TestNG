import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRunner extends Setup {
    LoginPage loginPage;
    ApplyLeavePage applyLeavePage;

    @Test(priority = 1, description = "Verify Login with valid credential")
    public void doLogin() {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }

    @Test(priority = 2, description = "Verify user redirects to the Apply Leave page correctly")
    public void redirectApplyLeavePage() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        applyLeavePage.redirectToApplyLeavePage();

        //Assertion
        String header_actual = driver.findElement(By.className("orangehrm-main-title")).getText();
        String header_expected = "Apply Leave";
        Assert.assertEquals(header_actual, header_expected);
    }

    @Test(priority = 3, description = "Verify user can not apply leave Request without selecting a valid date")
    public void cantApplyLeaveWithoutValidDate() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        applyLeavePage.oneDayLeave("20-20-12", "2024-28-2022", "Apply with an invalid date");
        Thread.sleep(200);
    }

    @Test(priority = 4, description = "Verify user can not apply leave Request on Vacation Date")
    public void cantApplyLeave() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        applyLeavePage.oneDayLeave("2024-25-12", "2024-28-2022", "Apply leave request on vacation date");
        Thread.sleep(200);
    }

    @Test(priority = 5, description = "Verify user can apply leave Request for one day")
    public void applyLeave() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        Thread.sleep(2000);
        applyLeavePage.oneDayLeave("2024-27-12", "2024-27-12", "Apply Sick Leave for one day");
        Thread.sleep(200);
    }

    @Test(priority = 6, description = "Verify user can not apply same leave Request twice")
    public void applyLeaveTwice() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        applyLeavePage.oneDayLeave("2024-27-12", "2024-27-12", "Apply leave twice with the same date");
        Thread.sleep(200);
    }

    @Test(priority = 7, description = "Verify user can not apply if he exceeds the leave balance")
    public void exceedsApplyLeave() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        applyLeavePage.oneDayLeave("2024-27-12", "2025-01-26", "exceeds the leave balance");
        Thread.sleep(200);
    }
}
