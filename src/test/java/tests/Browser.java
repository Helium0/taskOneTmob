package tests;

import factory.DriverManager;
import factory.WebFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import projectHelper.WaitClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Browser {

    private static final Logger logger = LogManager.getLogger(Browser.class);

    @Before(order = 0)
    public void openBrowser() {
        logger.info("Launching browser");
        WebDriver driver = WebFactory.webBrowser("Chrome");  // You can set browser dynamically
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    @Before(order = 1)
    public void goToWebsite() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.t-mobile.pl");

        HomePage homePage = new HomePage(driver);
        WaitClass.waitForElement(driver, homePage.getCookieButton());
        homePage.clickOnCookieButton();
    }

    @After
    public void closeBrowser() {
        logger.info("Closing browser");
        DriverManager.quitDriver();
    }
}

