package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage<product> {
    private static WebDriver driver;
    private static String currency;

    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search")
    private static WebElement searchBar;

    @FindBy(css = "#form-currency > div > button")
    private static WebElement currencyButton;

    @FindBy(css = "#form-currency > div > ul > li:nth-child(3) > button")
    private WebElement usdButton;

    @FindBy(css = "#content > div.row > div:nth-child(2) > div > div.caption > h4 > a")
    private static WebElement product;


    public static void changeCurrency(String currency) {
        HomePage.currency = currency;
        currencyButton.click();
        WebElement selectCurrency = driver.findElement(By.name(currency));
        selectCurrency.click();
    }

    public static void searchAndClickFeaturedProduct(String product) {
        WebElement productLink = driver.findElement(By.linkText(product));
        productLink.click();
        new ProductPage(driver);
    }
}