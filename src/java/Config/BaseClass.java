package Config;

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
    public static AndroidDriver driver;
    @BeforeClass
    public static void bb(){
        if (driver==null){
            driver=ConfigManager.setUp(AVDS.PIXELNATIVE);
        }
    }
    @AfterClass
    public static void a() throws InterruptedException {
        Thread.sleep(10000);
        if (driver!=null){
            driver.quit();
        }
    }
}