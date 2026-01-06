package tests;

import core.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;

import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = DriverFactory.createDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            saveScreenshot();
        }
        DriverFactory.quitDriver();
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot() {
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}
