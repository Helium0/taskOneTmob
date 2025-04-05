package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import projectHelper.WaitClass;

import java.util.List;

public class ProductPage {


    protected WebDriver driver;

    private final By CART_BUTTON = By.xpath("//span[@class='buttonText']");


    public List<WebElement> getAddToBasketButton() {
        return driver.findElements(CART_BUTTON);
    }

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Basket clickOnAddToBasketButton() {
        WaitClass.waitForLocator(driver,CART_BUTTON);
        getAddToBasketButton().get(1).click();
        return new Basket(driver);
    }

}
