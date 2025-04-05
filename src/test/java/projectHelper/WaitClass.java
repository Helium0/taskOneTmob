package projectHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitClass {


    public static WebDriverWait waitForParticularLocator(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public static WebElement waitForLocator(WebDriver driver, By locator) {
        return waitForParticularLocator(driver).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElement(WebDriver driver, WebElement element) {
        return waitForParticularLocator(driver).until(ExpectedConditions.elementToBeClickable(element));
    }


}
