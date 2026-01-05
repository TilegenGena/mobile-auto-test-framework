package tests;

import core.DriverFactory;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = DriverFactory.createDriver();
    }

    @AfterMethod()
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
