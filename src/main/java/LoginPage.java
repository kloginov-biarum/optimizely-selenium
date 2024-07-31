import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    // Form fields
    @FindBy(id = "UserName")
    private WebElement userNameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "Submit")
    private WebElement submitButton;
    @FindBy(css = "div.text--error")
    private WebElement errorMessage;
    // Constructor
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // Methods to interact with the form fields
    public void enterUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    // New method to enter username
    public void enterUsername(String username) {
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    // Optionally, add additional methods for specific actions or retrieving information from the form
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public boolean isUserNameFieldDisplayed() {
        return userNameField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed();
    }

    // New method to click on login button
    public void clickOnLoginButton() {
        submitButton.click();
    }
    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed() && errorMessage.getText().contains("Login failed");
    }



}

