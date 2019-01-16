package PageObjectModelProgram;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static PageObjectModelProgram.BrowserSelector.driver;

public class RegistrationPage extends Utils {
   // LoadProp loadProp = new LoadProp();
    SoftAssert softAssert = new SoftAssert();
    By reg_link=By.linkText("Register");
    By gender=By.id("gender-female");
    By firstName=By.id("FirstName");
    By lastName=By.id("LastName");
    By dateDay=By.name("DateOfBirthDay");
    By month=By.name("DateOfBirthMonth");
    By year=By.name("DateOfBirthYear");
    By email=By.id("Email");
    By company=By.id("Company");
    By newsletter=By.id("Newsletter");
    By password=By.id("Password");
    By confirmPassword=By.id("ConfirmPassword");
    By registerButton=By.id("register-button");
    By logOut=By.linkText("Log out");
 By actualMessage=By.xpath("//div[@class='result']");
    public void userShouldBeAbleToRegisterSuccessfully() {
        //Click on Register link
         clickElement(reg_link);
        //Select gender
        clickElement(gender);
        //Enter Firstname
        enterText(firstName, readTestDataFile("FirstName"));
        //Enter Lastname
        enterText(lastName, readTestDataFile("LastName"));
        //Select date of birth
        int num=Integer.valueOf(readTestDataFile("DateDay"));
        selectByIndex(dateDay,num);
        //Select date of month
        selectbyVisibleText(month, readTestDataFile("Month"));
        //Select date of Year
        selectByValue(year, readTestDataFile("Year"));
        //Enter Email
        enterText(email, readTestDataFile("Email")+dateStamp()+"@test.com");
        //Enter Company name
        enterText(company, readTestDataFile("Company"));
        //Enter Newsletter option
        driver.findElement(newsletter).isSelected();
        //Enter Password
        enterText(password, readTestDataFile("Password"));
        //Enter ConfirmPassword
        enterText(confirmPassword, readTestDataFile("ConfirmPassword"));
        //Click Register button
        clickElement(registerButton);
        //Expected Result
        String expectedRegisterSuccessMessage = "Your registration completed";
        String actualRegisterSuccessMessage=getText(actualMessage);
        //assert use to compare expected and actual result are same or not
        softAssert.assertEquals(expectedRegisterSuccessMessage,actualRegisterSuccessMessage,"Registration Fail");
        softAssert.assertAll();
        //Click logout button
        clickElement(logOut);
    }
}
