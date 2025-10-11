package Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


public class Driver {

    public static WebDriver driver;
    static ChromeOptions options;
    static EdgeOptions Eoptions;
    static FirefoxOptions Foptions;

    @Step("create browser: {name}")
    public static void Browserselections(String name) {

        if (name == null) {
            options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments(("--disable-popup-blocking"));
            options.addArguments("--disable--extensions");
            Logsutils.info("Driver is initiated as a ", "Chrome driver");
            driver = new ChromeDriver(options);
        } else if (name.equalsIgnoreCase("Chrome")) {
            options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments(("--disable-popup-blocking"));
            options.addArguments("--disable--extensions");
            Logsutils.info("Driver is initiated as a ", "Chrome driver");
            driver = new ChromeDriver(options);

        } else if (name.equalsIgnoreCase("Edge")) {
            Eoptions = new EdgeOptions();
            Eoptions.addArguments("--start-maximized");
            Eoptions.addArguments("--disable-notifications");
            Eoptions.addArguments(("--disable-popup-blocking"));
            Eoptions.addArguments("--disable--extensions");
            Logsutils.info("Driver is initiated as an ", "Edge driver");
            driver = new EdgeDriver(Eoptions);

        } else if (name.equalsIgnoreCase("Firefox")) {
            Foptions = new FirefoxOptions();
            Foptions.addArguments("--start-maximized");
            Foptions.addArguments("--disable-notifications");
            Foptions.addArguments(("--disable-popup-blocking"));
            Foptions.addArguments("--disable--extensions");
            Logsutils.info("Driver is initiated as a ", "FireFox driver");
            driver = new FirefoxDriver(Foptions);


        } else if (name.equalsIgnoreCase("Safari")) {

            driver = new SafariDriver();
            Logsutils.info("Driver is initiated as a ", "Safari driver");
            driver.manage().window().maximize();

        } else {
            options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments(("--disable-popup-blocking"));
            options.addArguments("--disable--extensions");
            Logsutils.info("Driver is initiated as a ", "Chrome driver");
            driver = new ChromeDriver(options);
        }
    }

    @Step("navigating to URL")
    public static void Browserinitiations() {
        Waits.waits();
        driver.get("https://flutter-angular.web.app/#/");
        Logsutils.info("driver is directed to Home URL ", "https://flutter-angular.web.app/#/");

    }

    @Step("Closing the browser")
    public static void TearOut() {
        driver.quit();
        Logsutils.info("driver is closed successfully");
    }

}