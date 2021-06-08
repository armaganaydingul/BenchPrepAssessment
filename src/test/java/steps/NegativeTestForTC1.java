package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;

public class NegativeTestForTC1 {
    WebDriver driver;
    LoginPage loginPage;

    @Before()
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.codewars.com/");
        loginPage = new LoginPage(driver);
        loginPage.login.click();
    }


    @When("the user provides the invalid {string} and {string}")
    public void theUserProvidesTheInvalidUsernameAndPassword(String username, String password) {
        loginPage.sendLoginKeys(username, password);
    }

    @Then("the user shouldn't be able to login")
    public void the_user_shouldn_t_be_able_to_login() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
