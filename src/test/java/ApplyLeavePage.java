import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ApplyLeavePage {
    @FindBy(className = "oxd-text")
    List<WebElement> LeaveBtn;
    @FindBy(className = "oxd-topbar-body-nav-tab-item")
    WebElement ApplyBtn;
    @FindBy(className = "oxd-select-text-input")
    List<WebElement> dropDown;

    @FindBy(className = "oxd-input")
    List<WebElement> inputField;

    @FindBy(className = "oxd-textarea")
    WebElement textArea;

    @FindBy(css = "[type=submit]")
    WebElement submitBtn;
    public ApplyLeavePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void redirectToApplyLeavePage() throws InterruptedException {
        LeaveBtn.get(2).click();
        Thread.sleep(200);
        ApplyBtn.click();
    }
    public void oneDayLeave(String formDate, String toDate, String comments) throws InterruptedException {

        //Selecting Leave Type
        dropDown.get(0).click();
        dropDown.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        dropDown.get(0).sendKeys(Keys.ENTER);

        // Select Date
        inputField.get(1).sendKeys(formDate);
        inputField.get(2).sendKeys(Keys.CONTROL + "a" , Keys.BACK_SPACE);
        inputField.get(2).sendKeys(toDate);


        textArea.sendKeys(comments);
        submitBtn.click();
    }
}
