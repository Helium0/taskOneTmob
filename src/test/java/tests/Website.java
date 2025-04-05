package tests;

import factory.Browser;
import factory.WebFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.*;
import projectHelper.ActionClass;
import projectHelper.SoftAssertClass;
import projectHelper.WaitClass;


public class Website extends Browser {


    private final By START_PAYMENT = By.xpath("//span[@data-qa='BKT_TotalupFront']");
    private final By MONTHLY_PAYMENT = By.xpath("//span[@data-qa='BKT_TotalMonthly']");
    private final By ITEMS_IN_BASKET = By.xpath("//span[@class='sr-only']/following-sibling::div");
    private final int MOBILE_DEVICE_INDEX = 1;  // You can change which mobile index do you want

    protected Logger logger;


    @Test
    public void addProductToTheBasket() {

        logger = LogManager.getLogger(this.getClass().getName());
        logger.info("Launching test: *** addProductToTheBasket ***");
        HomePage homePage = new HomePage(driver);
        SubBar subBar = new SubBar(driver);
        DevicesWIthoutSubscription devicesWIthoutSubscription = new DevicesWIthoutSubscription(driver);
        ProductPage productPage = new ProductPage(driver);
        Basket basket = new Basket(driver);
        WebElement hookedDevices = homePage.getDevicesButton();
        ActionClass.actions(driver).moveToElement(hookedDevices).perform();
        WaitClass.waitForElement(driver,subBar.getSmartfonsWithoutSubscriptionSectionButton());
        subBar.clickOnSmartfonsWithoutSubscriptionSectionButton();
        devicesWIthoutSubscription.clickOnDemandedIndexFromMobilePhoneList(MOBILE_DEVICE_INDEX);
        productPage.clickOnAddToBasketButton();
        WaitClass.waitForElement(driver,basket.getStartPaymentText());

        try {

            String startPaymentText = WebFactory.driver.findElement(START_PAYMENT).getText();
            SoftAssertClass.getInstance().assertEquals(startPaymentText, "19", "Start payment is incorrect");
            logger.info("Start payment assertion CHECKED: Expected 19, Found: " + startPaymentText);
            String monthlyPaymentText = WebFactory.driver.findElement(MONTHLY_PAYMENT).getText();
            SoftAssertClass.getInstance().assertEquals(monthlyPaymentText, "45", "Monthly payment is incorrect");
            logger.info("Monthly payment assertion CHECKED: Expected 45, Found: " + monthlyPaymentText);
            basket.clickOnLogoImageButtonToReturnToHomePage();
            String itemsInBasketText = WebFactory.driver.findElement(ITEMS_IN_BASKET).getText();
            SoftAssertClass.getInstance().assertEquals(itemsInBasketText, "1", "Items in basket are incorrect");
            logger.info("Items in basket assertion CHECKED: Expected 1, Found: " + itemsInBasketText);
            SoftAssertClass.assertAll();
            logger.info("Test PASSED: addProductToTheBasket");

        } catch (AssertionError e) {
            logger.error("Test FAILED: addProductToTheBasket ", e);
            throw e;
        }

    }
}

