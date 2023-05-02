package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private static WebDriver driver;

    public ProductPage(WebDriver driver){
        ProductPage.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "li h2")
    private WebElement price;

    @FindBy (id = "button-cart")
    private WebElement cartButton;

    @FindBy (linkText = "#product-product > div.alert.alert-success.alert-dismissible")
    private WebElement successAlert;


    public String getPrice(){
        return price.getText();
    }

    public void addToCart() {
        cartButton.click();
    }
}