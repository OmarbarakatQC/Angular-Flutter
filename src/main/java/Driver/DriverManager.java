package Driver;


import Utils.Logsutils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import static org.testng.AssertJUnit.fail;


public class DriverManager {


    public static final ThreadLocal<WebDriver> DriverThreadlocal = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    @Step("Setting the driver")
    public static void setDriver(WebDriver driver) {
        DriverThreadlocal.set(driver);
        Logsutils.info("setting the driver");
    }

    @Step("Getting the driver")
    public static WebDriver getDriver() {
        Logsutils.info("get the driver with the selected browser");
        if (DriverThreadlocal.get() == null) {
            fail("driver is null");
        }
        return DriverThreadlocal.get();
    }

    @Step("Crate an instance of the driver")
    public static WebDriver createInstance(String BrowserName) {
        WebDriver driver = DriverFactory.getBrowser(BrowserName);
        setDriver(driver);
        Logsutils.info("get an instant version of the Driver");
        return getDriver();
    }
}