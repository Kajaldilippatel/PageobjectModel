package PageObjectModelProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TermAndCondititonPage extends Utils{
    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();
    By product=By.xpath("//ul[@class='top-menu']/li[6]/a");
    By addToCart=By.xpath("//div[@data-productid='41']/div[2]/div[3]/div/input[1]");
    By topMenu=By.xpath("//div[@id='bar-notification']/p/a");
    By checkout=By.id("checkout");
    By actualMessage=By.xpath("//div[@id=\"terms-of-service-warning-box\"]/p");
    By closeTopup=By.xpath("//button[@class='ui-button ui-corner-all ui-widget ui-button-icon-only ui-dialog-titlebar-close']");
    By clickTermCondition=By.id("termsofservice");
    public void userNeedToAcceptTermsAnsConditionAsPerBelowScreen() {
        String expectedConditionMessage = "Please accept the terms of service before the next step.";
        //click on jewelry product
        clickElement(product);
        //select product and click add to cart
        clickElement(addToCart);
        explicitWait(topMenu);
        //click top up menu shopping cart
        clickElement(topMenu);
        //click Checkout button
        clickElement(checkout);
        String actualConditionMeassage = getText(actualMessage);
        softAssert.assertEquals(expectedConditionMessage, actualConditionMeassage, "User Need to Accept Term and condtion test case fail");
       softAssert.assertAll();
        //close term and condition top up
        clickElement(closeTopup);
        //click term and condition
        clickElement(clickTermCondition);
    }
}
