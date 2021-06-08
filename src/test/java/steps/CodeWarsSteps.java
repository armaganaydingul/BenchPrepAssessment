package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.EnrollPage;
import pages.LoginPage;
import pages.SearchPage;

public class CodeWarsSteps {
    WebDriver driver;
    LoginPage loginPage;
    EnrollPage enrollPage;
    SearchPage searchPage;
    WebDriverWait wait;
    String courseName;
    Actions actions;


    @Before()
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.codewars.com/");
        loginPage = new LoginPage(driver);
        loginPage.login.click();
        loginPage.sendLoginKeys("benchprep@sdet.com", "c0d3Ch@llenge21");
        enrollPage = new EnrollPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Then("the user is on the homepage and title is {string}")
    public void theUserIsOnTheHomepageAndTitleIs(String expectedTitle) throws InterruptedException {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected!");
        Thread.sleep(2000);
    }


    @When("the user clicks train button")
    public void theUserClicksTrainButton() {
        enrollPage.trainButton.click();
    }

    @Then("user enrolls in a course and title should start with {string}")
    public void userEnrollsInACourseAndTitleShouldStartWith(String expectedTitle) throws InterruptedException {
        Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.startsWith(expectedTitle));
        Thread.sleep(2000);
    }

    @When("the user search the  {string}")
    public void theUserSearchTheKeyword(String course) throws InterruptedException {

        courseName = course;
        actions = new Actions(driver);
        actions.moveToElement(searchPage.kataButton).build().perform();
        searchPage.kataButton.click();
        Thread.sleep(1000);
        searchPage.searchField.sendKeys(course);
        searchPage.searchButton.click();
    }

    @Then("user sees the results related with keyword")
    public void user_sees_the_results_related_with_keyword() {

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(searchPage.kataSearch));
        for (WebElement links : searchPage.listOfLinks) {
            org.junit.Assert.assertTrue(links.getText().toLowerCase().contains(courseName.toLowerCase()));
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
