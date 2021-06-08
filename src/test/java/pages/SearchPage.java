package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Kata']//..")
    public WebElement kataButton;

    @FindBy(id = "search-input")
    public WebElement searchField;

    @FindBy(id = "search")
    public WebElement searchButton;


    @FindBy(xpath = "//a[@href='/kata/525d9b1a037b7a9da7000905']")
    public WebElement kataSearch;

    @FindBy(xpath = "//div[@class='is-inline is-hidden js-check text-sm']/following-sibling::a")
    public List<WebElement> listOfLinks;

}