package PageObjectModelProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class RegisterUserSendMailSuccessFully extends Utils {
    LoginPage loginObject=new LoginPage();
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    By product=By.xpath("//div[@class='product-item'][@data-productid='4']/div/a/img");
    By emailButton=By.xpath("//div[@class='email-a-friend']/input");
    By friendEmail=By.xpath("//input[@class='friend-email']");
    By textArea=By.xpath("//textarea[@class='your-email']");
    By sendEmail=By.xpath("//input[@name='send-email']");
    By actualMessage=By.xpath("//div[@class='page email-a-friend-page']/div/div[2]");
    public void RegisteredUserShouldBeAbleToSendEmailWithProductSuccessfully(){
        String expectedEmailSuccessMessage="Your message has been sent.";
        loginObject.login();
        //select product to email a friend
        clickElement(product);
        //click on email a friend
        clickElement(emailButton);
        //enter friend email address
        enterText(friendEmail, readTestDataFile("FriendEmail"));
        //enter message
        enterText(textArea, readTestDataFile("TextArea"));
        //click on send email button
        clickElement(sendEmail);
        String actualEmailSuccessMessage=getText(actualMessage);
        softAssert.assertEquals(expectedEmailSuccessMessage,actualEmailSuccessMessage,"Registered user should be able to send email with product successfully test case fail");
        softAssert.assertAll();
        //click on logout button
        clickElement(By.linkText("Log out"));
    }
}
