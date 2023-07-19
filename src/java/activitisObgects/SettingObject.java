package activitisObgects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingObject {
    static AndroidDriver driver;

    public SettingObject(AndroidDriver driver) {
        this.driver = driver;
    }

    By temperatureButton = By.id("com.weather.forecast.weatherchannel:id/tgTemperature_setting");
    By speedButton = By.id("com.weather.forecast.weatherchannel:id/iv_arrow_distance");
    By listSpeedMetrics = By.id("com.weather.forecast.weatherchannel:id/md_contentRecyclerView");
    By notificationButton = By.id("com.weather.forecast.weatherchannel:id/tgNotifi_settings");
    By statusBarButton = By.id("com.weather.forecast.weatherchannel:id/tg_notifi_second_settings");
    By timeFormatButton = By.id("com.weather.forecast.weatherchannel:id/tg_format_time_setting");

    public void selectSpeedMetric(SPEED speed) {
        MobileElement tempButton = (MobileElement) driver.findElement(speedButton);
        if (!tempButton.getText().equals(speed.getSp())) {
            tempButton.click();
            MobileElement listMetrics = (MobileElement) new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(listSpeedMetrics));

            for (MobileElement l : listMetrics.findElements(By.className("android.widget.LinearLayout"))) {
                //     System.out.println(l.findElement(By.className("android.widget.TextView")).getAttribute("text"));
                if (l.findElement(By.className("android.widget.TextView")).getAttribute("text").equals(speed.getSp())) {
                    l.click();
                    break;
                }
            }
        }
    }

    public void temSelect(TEMP temp) {
        MobileElement tempButton = (MobileElement) driver.findElement(temperatureButton);
        switch (temp) {
            case C -> {
                if (tempButton.getAttribute("checked").equals("true")) {
                    tempButton.click();
                }
            }
            case F -> {
                if (tempButton.getAttribute("checked").equals("false")) {
                    tempButton.click();
                }
            }

        }
    }

    public enum TEMP {
        C, F;
    }

    public enum SPEED {
        KM("km/h"), M("m/s");

        public String getSp() {
            return sp;
        }

        String sp;

        SPEED(String s) {
            sp = s;
        }
    }

    public void notificationSelect(Notif notif) {
        MobileElement notifButton = (MobileElement) driver.findElement(notificationButton);
        switch (notif) {
            case on -> {
                if (notifButton.getAttribute("checked").equals("true")) {
                    notifButton.click();
                }
            }
            case of -> {
                if (notifButton.getAttribute("checked").equals("false")) {
                    notifButton.click();
                }
            }
        }
    }

    public enum Notif {
        on, of;
    }

    public void setStatusBarButtonSelect(Status status) {
        MobileElement notifButton = (MobileElement) driver.findElement(statusBarButton);
        switch (status) {
            case on -> {
                if (notifButton.getAttribute("checked").equals("true")) {
                    notifButton.click();
                }
            }
            case of -> {
                if (notifButton.getAttribute("checked").equals("false")) {
                    notifButton.click();
                }
            }
        }
    }

    public enum Status {
        on, of;
    }
    public void setTimeFormatButton(Time time) {
        MobileElement notifButton = (MobileElement) driver.findElement(timeFormatButton);
        switch (time) {
            case twelve -> {
                if (notifButton.getAttribute("checked").equals("true")) {
                    notifButton.click();
                }
            }
            case twenty -> {
                if (notifButton.getAttribute("checked").equals("false")) {
                    notifButton.click();
                }
            }
        }
    }

    public enum Time {
        twelve, twenty;
    }
}


