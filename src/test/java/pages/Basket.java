package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Basket {

    protected WebDriver driver;

    @FindBy(xpath = "//span[@data-qa='BKT_TotalupFront']")
    private WebElement startPaymentText;

    @FindBy(css = ".sc-kpDqfm.bxTqZb.dt_mainImage.customStyle.imgLoaded")
    private WebElement logoImageButton;

    public WebElement getStartPaymentText() {
        return startPaymentText;
    }


    public Basket(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage clickOnLogoImageButtonToReturnToHomePage() {
        logoImageButton.click();
        return new HomePage(driver);
    }




}
