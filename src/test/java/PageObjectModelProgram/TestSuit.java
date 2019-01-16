package PageObjectModelProgram;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class TestSuit extends BaseTest {

    @Test(priority =1 )
    public void verifySuccsessfullyRegistration() {
         RegistrationPage register=new RegistrationPage();
         register.userShouldBeAbleToRegisterSuccessfully();
         System.out.println("Register Test case Success");
    }
    @Test(priority = 2)
    public void registerUserCanSendProductMailSuccessFully(){
        RegisterUserSendMailSuccessFully sendMail=new RegisterUserSendMailSuccessFully();
        sendMail.RegisteredUserShouldBeAbleToSendEmailWithProductSuccessfully();
        System.out.println("Send Product Mail Test case Success");
    }
    @Test(priority = 3)
    public void UnRegisterUserCanNotSendMailSuccessfully()
    {
        UnRegisterUserCanNotSendMailSuccessfully sendMail=new UnRegisterUserCanNotSendMailSuccessfully();
        sendMail.toVerifyUnRegisteredUserShouldNOTBeAbleToSendEmail();
        System.out.println("Unregister Mail can not send mail Test case Success");
    }
    @Test(priority = 4)
    public void acceptTermAndConditon(){
        TermAndCondititonPage object=new TermAndCondititonPage();
        object.userNeedToAcceptTermsAnsConditionAsPerBelowScreen();
        System.out.println("Term and condition  Test case Success");
    }
   // @Test(priority = 5)
    public  void shoppingProduct(){
        PaymentPage payment=new PaymentPage();
        payment.registeredUserShouldBeAbleToBuyAnySingleProductSuccessfully();
        System.out.println(" Successful Buy Product Test Case Success");
    }
}