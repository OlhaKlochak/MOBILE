import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ConfigManager {
    public static RemoteWebDriver setUp(AVDS avds){
        switch (avds){
            case Pixel2403 -> {return setUpPixelAndroid11();}
        }
        return null;

    }

    private static RemoteWebDriver setUpPixelAndroid11() {
        RemoteWebDriver driver=null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(AndroidMobileCapabilityType.BROWSER_NAME,"Chrome");
        caps.setCapability("appium:chromedriverExecutable","C:\\driver74\\chromedriver.exe");
        caps.setCapability("appium:version", "10");//указываем версию Android
        caps.setCapability("appium:platformName", "Android");//Имя OS
        caps.setCapability("appium:deviceName", "emulator-5554");//Сообщаем, что будет использоваться эмулятор
       // caps.setCapability("appium:newCommandTimeout", 1800);
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
