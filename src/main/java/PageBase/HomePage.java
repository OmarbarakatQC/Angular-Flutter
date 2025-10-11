package PageBase;

import Utils.ElementActions;
import Utils.Logsutils;
import Utils.Validation;
import Utils.Waits;
import org.openqa.selenium.By;

public class HomePage {

    //locator
    private static final By listbutton =
            By.xpath("//span[@class='mat-mdc-button-touch-target']");
    private static final By addbutton =
            By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/ng-flutter/div/flutter-view");
    private static final By clicksbutton =
            By.xpath("//input[@id='mat-input-1']");


//actions

    public static void clickonlistbutton() {
        ElementActions.ClickButton(listbutton);
        Logsutils.info("the listbutton has been clicked ");

    }

    public static void clickonaddbutton() {
        try {
            Waits.Exwaits(addbutton);
            ElementActions.ClickButton(addbutton);
            Logsutils.info("adding button has been clicked");
        } catch (Exception e) {
        Logsutils.error("addbutton is not clicked"+e.toString());
        }
    }
    // validation

    public static void assertnumberadd(){
        Validation.validateActualcounter(clicksbutton,1);
    Logsutils.info("assertion was done successfully");
    }

}
