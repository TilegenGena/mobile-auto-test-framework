package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {
    private final By usernameField = AppiumBy.accessibilityId("test-Username");
    private final By passwordField = AppiumBy.accessibilityId("test-Password");
    private final By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    private final By productsTitle = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
    private final By errorText = By.xpath("//*[@content-desc='test-Error message']/*[@text]");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isLoginScreenDisplayed() {
        return isDisplayed(usernameField);
    }

    public void login(String username, String password) {
        waitAndSendKeys(usernameField, username);
        waitAndSendKeys(passwordField, password);
        waitAndClick(loginButton);
    }
    
    public boolean isProductsTitleDisplayed() {
        return isDisplayed(productsTitle);
    }
}
