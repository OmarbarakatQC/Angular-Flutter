package Utils;

import Driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ElementActions {


    @Step("Clicking on button: {locator}")
    public static void ClickButton(By locator) {
        try {
            Waits.waitForElementClickable(DriverManager.getDriver(), locator);
            DriverManager.getDriver().findElement(locator).click();
        } catch (Exception e) {
            Logsutils.error(locator.toString() + "is not found");
        }
    }
}