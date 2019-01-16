package PageObjectModelProgram;
import static PageObjectModelProgram.BrowserSelector.driver;

public class BasePage {
    public void openBrowser(){
        BrowserSelector bs=new BrowserSelector();
        bs.browser();
        driver.get("https://demo.nopcommerce.com/");
      //  System.out.println("Browser Open Successfully");
    }
    public void closeBrowser(){
        driver.quit();
      //  System.out.println("Close Browser");
    }
}


