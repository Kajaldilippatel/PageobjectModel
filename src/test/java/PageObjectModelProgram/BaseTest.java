package PageObjectModelProgram;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import static PageObjectModelProgram.BrowserSelector.driver;

public class BaseTest extends Utils {

    @BeforeMethod
    public void setUp() {
        openBrowser();
    }
    @AfterMethod
    public void screenSort(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("src\\test\\Resources\\Screensohorts\\" + result.getName() + ".png"));
                System.out.println("Screenshot taken");
            } catch (Exception e) {
                System.out.println("ScreenShot Taken While test Case fail " + e.getMessage());
            }

        }
            closeBrowser();
    }


}

