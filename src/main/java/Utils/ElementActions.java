package Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static Utils.Driver.driver;

public class ElementActions {

    @Step("Clicking on button: {locator}")
    public static void ClickButton(By locator) {
        try {
            Waits.waits();
            driver.findElement(locator).click();
        } catch (Exception e) {
            Logsutils.error(locator.toString() + "is not found");
        }
    }

    public static int getnumber(By locator){
       Integer.parseInt(driver.findElement(locator).getText());
        return 0;
    }

}