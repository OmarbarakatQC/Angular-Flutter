package Utils;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Validation {

    public static void validateActualcounter(By locator, int expected){

       int actualnumber =  ElementActions.getnumber(locator);
        Assert.assertEquals(actualnumber,expected);

    }










}
