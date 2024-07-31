import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{
    @Test
    public void loginTest(){
        driver.get("https://qa-school.flsmm.fls.cloud/util/Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("test1@optitest.com");
        loginPage.enterPassword("ePIsERVER123!$");
        loginPage.clickOnLoginButton();
        LandingPage landingPage = new LandingPage(driver);
        assertTrue(landingPage.catalogButtonIsDisplayed());
    }

    @Test
    public void unsuccessfulLoginWithIncorrectUsernameTest() {
        driver.get("https://qa-school.flsmm.fls.cloud/util/Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("wrong@optitest.com");
        loginPage.enterPassword("ePIsERVER123!$");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
    public void unsuccessfulLoginWithIncorrectPasswordTest() {
        driver.get("https://qa-school.flsmm.fls.cloud/util/Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("test1@optitest.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickOnLoginButton();
        assertFalse(new LandingPage(driver).catalogButtonIsDisplayed());
    }

    @Test
    public void loginWithEmptyUsernameTest() {
        driver.get("https://qa-school.flsmm.fls.cloud/util/Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("ePIsERVER123!$");
        loginPage.clickOnLoginButton();
        assertFalse(new LandingPage(driver).catalogButtonIsDisplayed());
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        driver.get("https://qa-school.flsmm.fls.cloud/util/Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("test1@optitest.com");
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();
        assertFalse(new LandingPage(driver).catalogButtonIsDisplayed());
    }

    @Test
    public void verifyLoginFormElementsTest() {
        driver.get("https://qa-school.flsmm.fls.cloud/util/Login");
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isUserNameFieldDisplayed());
        assertTrue(loginPage.isPasswordFieldDisplayed());
        assertTrue(loginPage.isSubmitButtonDisplayed());
    }
}
