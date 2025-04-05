package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubBar {

    protected  WebDriver driver;

    @FindBy(xpath = "//a[@data-ga-ea='nav-links - Urządzenia/Bez abonamentu/Smartfony']//span[text()='Smartfony']")
    private WebElement smartfonsWithoutSubscriptionSectionButton;


    public WebElement getSmartfonsWithoutSubscriptionSectionButton() {
        return smartfonsWithoutSubscriptionSectionButton;
    }

    public SubBar(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public DevicesWIthoutSubscription clickOnSmartfonsWithoutSubscriptionSectionButton() {
        smartfonsWithoutSubscriptionSectionButton.click();
        return new DevicesWIthoutSubscription(driver);
    }

}
