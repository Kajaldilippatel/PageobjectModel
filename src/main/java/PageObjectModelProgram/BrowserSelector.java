package PageObjectModelProgram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserSelector {
    public static WebDriver driver;
        public void browser(){
            LoadProp loadProp = new LoadProp();
            String browser = loadProp.getProperty("browser");
          //  String browser=System.getProperty("browser");
            if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\WebDriver\\geckodriver.exe");
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\WebDriver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
               options.addArguments("--disable-extensions");
               options.addArguments("--disable-browser-side-navigation");
               options.addArguments("--incognito");
                options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\WebDriver\\IEDriverServer.exe");
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver = new InternetExplorerDriver(options);
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
            } else {
                System.out.println("Browser name is empty or typed wrong :" + browser);
            }
        }
    }
