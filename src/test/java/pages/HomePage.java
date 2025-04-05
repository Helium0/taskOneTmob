package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected  WebDriver driver;

    @FindBy(id = "didomi-notice-agree-button")
    private WebElement cookieButton;

    @FindBy(xpath = "//button[text()='Urządzenia']")
    private WebElement devicesButton;


    public WebElement getCookieButton() {
        return cookieButton;
    }

    public WebElement getDevicesButton() {
        return devicesButton;
    }

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public HomePage clickOnCookieButton() {
        cookieButton.click();
        return new HomePage(driver);
    }


}
