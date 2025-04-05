package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebFactory {

    protected static WebDriver driver;


    public static WebDriver webBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome": return new ChromeDriver();
            case "firefox": return new FirefoxDriver();
            case "edge": return new InternetExplorerDriver();
            default:
                System.out.println("This browser doesn`t exist. Please write correct one");
        }
        return driver;
    }
}
