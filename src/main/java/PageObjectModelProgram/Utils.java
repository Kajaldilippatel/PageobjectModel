package PageObjectModelProgram;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static PageObjectModelProgram.BrowserSelector.driver;

public class Utils extends BasePage{
    LoadProp loadProp = new LoadProp();
  public WebElement findElement(By by){
      return driver.findElement(by);
  }
    public void clickElement(By by)
    {
    driver.findElement(by).click();
    }
    public void enterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public static String dateStamp() {
        DateFormat date = new SimpleDateFormat("MMddYYHHMMSS");
        Date date1 = new Date();
        String date2 = date.format(date1);
        return date2;
    }
    public static void selectByValue(By by, String number) {
        Select value = new Select(driver.findElement(by));
        value.selectByValue(number);
    }
    //select by index method
    public static void selectByIndex(By by, int number) {
        Select value = new Select(driver.findElement(by));
        value.selectByIndex(number);
    }
    //     //Select by visible text method
    public static void selectbyVisibleText(By by, String text) {
        Select value = new Select(driver.findElement(by));
        value.selectByVisibleText(text);
    }
    public static String getText(By by) {
        return driver.findElement(by).getText();

    }
    public String readTestDataFile(String string){
        String str=loadProp.getProperty(string);
        return str;
    }
    public Properties readTestDataSystem(String string){
        Properties str=System.getProperties();
        return  str;

    }
    public static void explicitWait(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void explicitWait1(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

}






