package runner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApplyLeavePage;
import pages.LoginPage;
import setup.Setup;

public class TestRunner extends Setup {
    LoginPage loginPage;
    ApplyLeavePage applyLeavePage;

    @Test(priority = 1, description = "Verify Login with valid credential")
    public void doLogin() {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");

        // Assertion
        String headerActualText = driver.findElements(By.className("oxd-text")).get(12).getText();
        String headerExpectedText = "Dashboard";
        Assert.assertEquals(headerActualText, headerExpectedText);
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

    @Test(priority = 3, description = "Verify user can not apply leave with selecting an invalid date")
    public void cantApplyLeaveWithoutValidDate() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        applyLeavePage.oneDayLeave("20-20-12", "2024-28-2022", "Apply with an invalid date");
        Thread.sleep(200);

        // Assertion
        String headerActualText = driver.findElements(By.className("oxd-text")).get(15).getText();
        String headerExpectedText = "Should be a valid date in yyyy-dd-mm format";
        Assert.assertEquals(headerActualText, headerExpectedText);
    }

    @Test(priority = 4, description = "Verify user can not apply leave on Vacation/Off Date")
    public void cantApplyLeave() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        applyLeavePage.oneDayLeave("2024-25-12", "2024-28-2022", "Apply leave request on vacation/Off date");
        Thread.sleep(200);
    }

    @Test(priority = 5, description = "Verify user can successfully apply leave for one day")
    public void applyOneDayLeave() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        Thread.sleep(2000);
        applyLeavePage.oneDayLeave("2024-27-12", "2024-27-12", "Apply Sick Leave for one day");
        Thread.sleep(200);
    }

    @Test(priority = 6, description = "Verify user can successfully apply leave for more days")
    public void applyMoreDayLeave() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        Thread.sleep(2000);
        applyLeavePage.oneDayLeave("2024-28-12", "2024-30-12", "Apply Sick Leave for more days");
        Thread.sleep(200);
    }

    @Test(priority = 7, description = "Verify user can not apply same leave Request twice")
    public void applyLeaveTwice() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        applyLeavePage.oneDayLeave("2024-27-12", "2024-27-12", "Apply leave twice with the same date");
        Thread.sleep(200);
    }

    @Test(priority = 8, description = "Verify user can not apply if he exceeds the leave balance")
    public void exceedsApplyLeave() throws InterruptedException {
        applyLeavePage = new ApplyLeavePage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
        applyLeavePage.oneDayLeave("2024-27-12", "2025-01-26", "exceeds the leave balance");
        Thread.sleep(200);
    }

    @Test(priority = 10, description = "Verify user can Logout Successfully")
    public void logOut() {
        loginPage = new LoginPage(driver);
        loginPage.doLogout();
    }
}
