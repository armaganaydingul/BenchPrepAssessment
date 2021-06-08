package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Log In']")
    public WebElement login;

    @FindBy(id = "user_email")
    public WebElement email;

    @FindBy(id = "user_password")
    public WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='alert-box error flash-msg error']")
    public WebElement errorMessage;

    public void sendLoginKeys(String username, String password) {
        email.sendKeys(username);
        pass.sendKeys(password);
        signInButton.click();
    }
}