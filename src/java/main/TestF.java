package main;

import Config.BaseClass;
import activitisObgects.SettingObject;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestF extends BaseClass {
    static SettingObject object;

    @BeforeClass
    public static void bef() {
        object = new SettingObject(driver);
    }

    @Test
    public void testSetting1() {
        System.out.println(driver.currentActivity());
    }

    @Test
    public void testSettingTemp1() {
        object.temSelect(SettingObject.TEMP.F);
    }

    @Test
    public void testSettingSpeed1() {
        object.selectSpeedMetric(SettingObject.SPEED.M);
    }
    @Test
    public void testNotifButton(){
        object.notificationSelect(SettingObject.Notif.of);
    }
    @Test
    public void testStatusButton(){
        object.setStatusBarButtonSelect(SettingObject.Status.of);
    }
    @Test
    public void testTimeFormatButton(){
        object.setTimeFormatButton(SettingObject.Time.twelve);
    }
}
