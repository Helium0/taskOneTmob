package tests;

import factory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import pages.*;
import projectHelper.ActionClass;
import projectHelper.SoftAssertClass;
import projectHelper.WaitClass;


public class Website {

    private final By START_PAYMENT = By.xpath("//span[@data-qa='BKT_TotalupFront']");
    private final By MONTHLY_PAYMENT = By.xpath("//span[@data-qa='BKT_TotalMonthly']");
    private final By ITEMS_IN_BASKET = By.xpath("//span[@class='sr-only']/following-sibling::div");
    private final int MOBILE_DEVICE_INDEX = 1;

    protected Logger logger;
    protected HomePage homePage;
    protected SubBar subBar;
    protected DevicesWIthoutSubscription devicesWIthoutSubscription;
    protected ProductPage productPage;
    protected Basket basket;

    @Given("Choose devices from top")
    public void choose_devices_from_top() {
        logger = LogManager.getLogger(this.getClass().getName());
        WebDriver driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        WebElement hookedDevices = homePage.getDevicesButton();
        ActionClass.actions(driver).moveToElement(hookedDevices).perform();
    }

    @And("Click smartfons from no subscription label")
    public void click_smartfons_from_no_subscription_label() {
        WebDriver driver = DriverManager.getDriver();
        subBar = new SubBar(driver);
        WaitClass.waitForElement(driver, subBar.getSmartfonsWithoutSubscriptionSectionButton());
        subBar.clickOnSmartfonsWithoutSubscriptionSectionButton();
    }

    @And("Click second element from list")
    public void click_secon_element_from_list() {
        WebDriver driver = DriverManager.getDriver();
        devicesWIthoutSubscription = new DevicesWIthoutSubscription(driver);
        devicesWIthoutSubscription.clickOnDemandedIndexFromMobilePhoneList(MOBILE_DEVICE_INDEX);
    }

    @When("Add product to the cart")
    public void add_product_to_the_cart() {
        WebDriver driver = DriverManager.getDriver();
        productPage = new ProductPage(driver);
        productPage.clickOnAddToBasketButton();
    }

    @Then("Back to home page")
    public void back_to_home_page() {
        WebDriver driver = DriverManager.getDriver();
        basket = new Basket(driver);
        WaitClass.waitForElement(driver, basket.getStartPaymentText());

        try {
            String startPaymentText = driver.findElement(START_PAYMENT).getText();
            SoftAssertClass.getInstance().assertEquals(startPaymentText, "19", "Start payment is incorrect");
            logger.info("Start payment assertion CHECKED: Expected 19, Found: " + startPaymentText);

            String monthlyPaymentText = driver.findElement(MONTHLY_PAYMENT).getText();
            SoftAssertClass.getInstance().assertEquals(monthlyPaymentText, "45", "Monthly payment is incorrect");
            logger.info("Monthly payment assertion CHECKED: Expected 45, Found: " + monthlyPaymentText);

            basket.clickOnLogoImageButtonToReturnToHomePage();

            String itemsInBasketText = driver.findElement(ITEMS_IN_BASKET).getText();
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


