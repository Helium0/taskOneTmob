package factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import projectHelper.WaitClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tests.Website;

public class Browser extends WebFactory {

    private static final Logger logger = LogManager.getLogger(Website.class);

    @BeforeTest
    public WebDriver getBrowser() {
        logger.info("Launching browser");
        driver = WebFactory.webBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.t-mobile.pl/");

        HomePage homePage = new HomePage(driver);
        WaitClass.waitForElement(driver, homePage.getCookieButton());
        homePage.clickOnCookieButton();
        return driver;
    }


    @AfterTest
    public void tearBrowser() {
        if (driver != null) {
        logger.info("Closing browser");
        driver.quit();
        }
    }
}
