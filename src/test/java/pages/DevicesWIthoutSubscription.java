package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DevicesWIthoutSubscription {

    protected WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'styles__StyledCards-sc-176tmlw-0')]/div")
    private List<WebElement> mobilePhoneList;


    public DevicesWIthoutSubscription(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage clickOnDemandedIndexFromMobilePhoneList(int index) {
        mobilePhoneList.get(index).click();
        return new ProductPage(driver);
    }

}
