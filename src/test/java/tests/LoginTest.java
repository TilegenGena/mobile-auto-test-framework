package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import constants.UiText;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginScreenDisplayed(), UiText.LOGIN_SCREEN_NOT_DISPLAYED);

        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertTrue(
                loginPage.isProductsTitleDisplayed(), UiText.TITLE_NOT_DISPLAYED);
    }

    @Test
    public void unsuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginScreenDisplayed(), UiText.LOGIN_SCREEN_NOT_DISPLAYED);

        loginPage.login(ConfigReader.get("invalidUsername"), ConfigReader.get("password"));
        Assert.assertTrue(
                loginPage.isErrorMessageDisplayed(), UiText.ERROR_MESSAGE_NOT_DISPLAYED);
    }
}
