package TestBase;

import PageBase.HomePage;
import Utils.Driver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class E2E_Test {


    @BeforeTest
    public void setup() {
        Driver.Browserselections("chrome");
        Driver.Browserinitiations();
    }


    @Test
    public static void E2Etest(){
        HomePage.clickonlistbutton();
        HomePage.clickonaddbutton();
        HomePage.assertnumberadd();

    }




//    @AfterTest
//    public void Tearout() {
//        Driver.TearOut();
//    }














}
