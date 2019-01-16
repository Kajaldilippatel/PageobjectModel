package PageObjectModelProgram;

import org.openqa.selenium.By;

public class LoginPage extends Utils{
    public void login(){
        By loginButton=By.xpath("//a[@href='/login']");
        By email=By.id("Email");
        By password=By.id("Password");
        By continueLoginButton=By.xpath("//input[@class='button-1 login-button']");
        //click on login button
        clickElement(loginButton);
        //enter email id
        enterText(email, readTestDataFile("YourEmail"));
        //enter password
        enterText(password, readTestDataFile("PassWord"));
        //click login button
        clickElement(continueLoginButton);
    }
}
