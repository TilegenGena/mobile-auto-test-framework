package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static AndroidDriver createAndroidDriver() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(ConfigReader.get("deviceName"));
        options.setAutomationName(ConfigReader.get("automationName"));

        return new AndroidDriver(
                new URL("http://localhost:4723/wd/hub"),
                options
        );
    }
}
