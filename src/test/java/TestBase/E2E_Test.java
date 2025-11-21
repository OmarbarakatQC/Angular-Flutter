package TestBase;

import Driver.DriverManager;
import PageBase.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class E2E_Test {

    @BeforeTest
    public void setup() throws IOException {
        DriverManager.createInstance("chrome");
        HomePage.navigateToHomePage();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement glassPane = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("flt-glass-pane")));
        String script = "document.querySelector('flt-glass-pane').shadowRoot.querySelector('flt-semantics-placeholder').click()";
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(script);
    }

    @Test
    public static void E2Etest() {
        HomePage.clickonaddbutton();
        HomePage.assertCounterAdd();
    }

    @AfterTest
    public void Tearout() {
        DriverManager.getDriver().quit();
    }
}
