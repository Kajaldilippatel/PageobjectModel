package PageObjectModelProgram;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class PaymentPage extends Utils {
    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();
    By jewelary=By.xpath("//ul[@class='top-menu']/li[6]/a");
    By addToCart=By.xpath("//div[@data-productid='41']/div[2]/div[3]/div/input[1]");
    By shopingCart=By.xpath("//div[@id='bar-notification']/p/a");
    By termCondition=By.id("termsofservice");
    By checkout=By.id("checkout");
    By country=By.id("BillingNewAddress_CountryId");
    By state=By.id("BillingNewAddress_StateProvinceId");
    By city=By.id("BillingNewAddress_City");
    By add1=By.id("BillingNewAddress_Address1");
    By zipCode=By.id("BillingNewAddress_ZipPostalCode");
    By phoneNo=By.id("BillingNewAddress_PhoneNumber");
    By contButton=By.xpath("//div[@id='billing-buttons-container']/input");
    By continueButton=By.xpath("//div[@id='shipping-method-buttons-container']/input[@value='Continue']");
    By creditButton=By.id("paymentmethod_1");
    By creditContButton=By.xpath("//div[@id='payment-method-buttons-container']/input");
    By cardHolderName=By.id("CardholderName");
    By cardNumber=By.id("CardNumber");
    By expMonth=By.id("ExpireMonth");
    By expYear=By.id("ExpireYear");
    By cardCode=By.id("CardCode");
    By paymentButton=By.xpath("//div[@id='payment-info-buttons-container']/input");
    By confirmMessage=By.xpath("//div[@id='confirm-order-buttons-container']/input");
    By actualMessage=By.xpath("//div[@class='section order-completed']/div");
    By ConfirmShopping=By.xpath("//div[@class='section order-completed']/div[3]/input");
    By logout=By.linkText("Log out");

    public void registeredUserShouldBeAbleToBuyAnySingleProductSuccessfully()
    {
        String expectedBuyProductSuccessfullyMessage="Your order has been successfully processed!";
        LoginPage objectLogin=new LoginPage();
        objectLogin.login();
        //click on jewelry
        clickElement(jewelary);
        //select product and click add to cart
        clickElement(addToCart);
        explicitWait(shopingCart);
        //click top up menu shopping cart
        clickElement(shopingCart);
        //click term and condition
        clickElement(termCondition);
        //click Checkout button
        clickElement(checkout);
        //select country
       selectByValue(country,readTestDataFile("Country"));
        //select state
       selectByValue(state,readTestDataFile("State"));
        //enter city
        enterText(city, readTestDataFile("City"));
        //Enter address 1
        enterText(add1, readTestDataFile("Address1"));
        //enter zip code
        enterText(zipCode, readTestDataFile("ZipCode"));
        //enter phone no
        enterText(phoneNo, readTestDataFile("PhoneNo"));
        //click continue button
        clickElement(contButton);
        //click continue
        explicitWait(continueButton);
        clickElement(continueButton);
        //select credit card button
        clickElement(creditButton);
        //click continue button
        clickElement(creditContButton);
        //enter card Holdername
        enterText(cardHolderName,readTestDataFile("CardHolderName"));
        //enter card number
        enterText(cardNumber,readTestDataFile("CardNumber"));
        //Select expire month   //select[@id='ExpireMonth']
        selectByValue(expMonth,"2");
        //select expire year
        selectByValue(expYear,"2020");
        //entre card code
        enterText(cardCode,readTestDataFile("CardCode"));
        //click continue
        clickElement(paymentButton);
        //confirm Message
        clickElement(confirmMessage);
        String actualBuyProductSuccessfullyMessage=getText(actualMessage);
        //click continue
        clickElement(ConfirmShopping);
        //click on logout button
        clickElement(logout);
        softAssert.assertEquals(expectedBuyProductSuccessfullyMessage,actualBuyProductSuccessfullyMessage,"Product buy Successfully test case fail");
       softAssert.assertAll();

    }
}
