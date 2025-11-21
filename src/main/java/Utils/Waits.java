package Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    @Step("Waiting for an element to be present")
    public static WebElement waitForElementPresent(WebDriver driver, By locator) {
        Logsutils.info("Waiting for an element to be present");
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 -> driver1.findElement(locator));
    }

    @Step("Waiting for an element to be visible")
    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        Logsutils.info("Waiting for an element to be visible");
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                {
                    WebElement element = waitForElementPresent(driver, locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    @Step("Waiting for an element to be Clickable")
    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        Logsutils.info("Waiting for an element to be Clickable");
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver1 ->
                {
                    WebElement element = waitForElementVisible(driver, locator);
                    return element.isEnabled() ? element : null;
                });
    }
}
