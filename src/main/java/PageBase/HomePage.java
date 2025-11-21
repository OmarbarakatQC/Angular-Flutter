package PageBase;

import Driver.DriverManager;
import Utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;


public class HomePage {

    //locator
    private static final By listbutton =
            By.xpath("//span[@class='mat-mdc-button-touch-target']");
    private static final By addbutton =
            By.xpath("//flt-semantics[@id='flt-semantic-node-8']");
    private static final By clicksbutton =
            By.xpath("//input[@id='mat-input-1']");


    //actions
    @Step("navigating to URL")
    public static void navigateToHomePage() throws IOException {
        DriverManager.getDriver().get(DataLoad.dataLoad("Base_URL"));
        Logsutils.info("driver is directed to Home URL ", DataLoad.dataLoad("Base_URL"));
    }

    @Step("click on add button")
    public static void clickonaddbutton() {
        try {
            ElementActions.ClickButton(addbutton);
            Logsutils.info("adding button has been clicked");
        } catch (Exception e) {
            Logsutils.error("addbutton is not clicked" + e.toString());
        }
    }

    // validation
    @Step("validating the clicking process")
    public static void assertCounterAdd() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement glassPane = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("flt-glass-pane")));
        WebElement element = DriverManager.getDriver().findElement(By.id("flt-semantic-node-5"));
        Assert.assertEquals(element.getAttribute("aria-label"), "1");
    }
}
