package PageObjectModelProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class UnRegisterUserCanNotSendMailSuccessfully extends Utils{
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    RegisterUserSendMailSuccessFully object=new RegisterUserSendMailSuccessFully();

   By yourEmailId=By.xpath("//input[@class='your-email']");
   By actualMessage=By.xpath("//div[@class='message-error validation-summary-errors']/ul/li");
    public void toVerifyUnRegisteredUserShouldNOTBeAbleToSendEmail(){
        String expectedNotEmailSuccessMessage="Only registered customers can use email a friend feature";
        //Select Product
        clickElement(object.product);
        //click email a friend link
        clickElement(object.emailButton);
        //enter friend email id
        enterText(object.friendEmail,readTestDataFile("FriendEmail"));
        //enter your email id
        enterText(yourEmailId,readTestDataFile("YourEmail"));
        //enter text
        enterText(object.textArea,readTestDataFile("TextArea"));
        //click send email button
        clickElement(object.sendEmail);
        String actualNotEmailSuccessMessage=getText(actualMessage);
        softAssert.assertEquals(expectedNotEmailSuccessMessage,actualNotEmailSuccessMessage,"Un-registered use should NOT be able to send email test case fail");
        softAssert.assertAll();
    }

}
