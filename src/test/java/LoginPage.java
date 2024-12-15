import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(className = "oxd-input")
    List<WebElement> adminCredential;
    @FindBy(className = "oxd-button")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String userName, String password) {
        adminCredential.get(0).sendKeys(userName);
        adminCredential.get(1).sendKeys(password);
        loginBtn.click();
    }


}
