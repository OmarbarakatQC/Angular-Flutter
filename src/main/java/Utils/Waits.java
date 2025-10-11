package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utils.Driver.driver;

public class Waits {

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public static void waits() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Logsutils.info("A global implicit wait have been used here with waiting time of 10 sec ");
    }

    public static void Exwaits(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Logsutils.info("An explicit wait have been used here to wait for an element to be clickable");
    }

}
