package Driver;

import Utils.Logsutils;
import io.qameta.allure.Step;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {

    static EdgeOptions edgeOptions;
    static FirefoxOptions firefoxOptions;
    static SafariOptions safariOptions;
    static ChromeOptions chromeoptions;

    @Step("create Browser")
    public static WebDriver getBrowser(String BrowserName) {

        switch (BrowserName.toLowerCase()) {

            case "edge":
                edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-popup-blocking");
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-features=PasswordBreachDetection");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-gpu");
                Logsutils.info("browser was selected as Edge browser");
                return new EdgeDriver(edgeOptions);

            case "firefox":
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--disable-popup-blocking");
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--disable-extensions");
                firefoxOptions.addArguments("--disable-features=PasswordBreachDetection");
                firefoxOptions.addArguments("--disable-dev-shm-usage");
                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--disable-gpu");
                Logsutils.info("browser was selected as Firefox browser");
                return new FirefoxDriver(firefoxOptions);

            case "safari":
                safariOptions = new SafariOptions();
                safariOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                Logsutils.info("browser was selected as safari browser");
                return new SafariDriver(safariOptions);

            default:
                chromeoptions = new ChromeOptions();
                chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeoptions.addArguments("--disable-notifications");
                chromeoptions.addArguments("--disable-popup-blocking");
                chromeoptions.addArguments("--start-maximized");
                chromeoptions.addArguments("--disable-extensions");
                chromeoptions.addArguments("--disable-features=PasswordBreachDetection");
                chromeoptions.addArguments("--disable-dev-shm-usage");
                chromeoptions.addArguments("--no-sandbox");
                chromeoptions.addArguments("--disable-gpu");
                Logsutils.info("browser was selected as Chrome browser");
                return new ChromeDriver(chromeoptions);
        }
    }
}
