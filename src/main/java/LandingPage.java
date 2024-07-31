import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    //test1@optitest.com
    //ePIsERVER123!$

    private WebDriver driver;
    // Form fields
    @FindBy(id = "UserName")
    private WebElement userNameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "Submit")
    private WebElement submitButton;

    @FindBy(css = "[type=\"button\"]")
    private WebElement catalogButton;
    // Constructor
    public LandingPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the form fields
    public void enterUserName(String userName) {
        userNameField.sendKeys(userName);
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
    // New method to check if catalog button is displayed
    public boolean catalogButtonIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(catalogButton));
        return catalogButton.isDisplayed();
    }



}
