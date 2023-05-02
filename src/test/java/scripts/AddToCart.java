package scripts;

import dataProviders.ProductsData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;

public class AddToCart {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (dataProvider = "products", dataProviderClass = ProductsData.class)
    public void test(String currency, String product, String price) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://opencart.abstracta.us/");
        HomePage homePage = new HomePage(driver);
        homePage.changeCurrency(currency);
        homePage.searchAndClickFeaturedProduct(product);
        ProductPage productPage = new ProductPage(driver);
        assertEquals(productPage.getPrice(), price);
        productPage.addToCart();
    }
}