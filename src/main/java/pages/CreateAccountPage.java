package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

import java.util.Random;

public class CreateAccountPage extends AbstractObjectPage {

    @FindBy(xpath = "/html/body/div/form/div/h4/a")
    private WebElement createAccount;

    @FindBy (id = "username")
    private WebElement createUsername;

    @FindBy (id = "password")
    private WebElement createPassword;

    @FindBy (id = "passwordConfirm")
    private WebElement confirmPassword;

    @FindBy (xpath = "//*[@id=\"userForm\"]/button")
    private WebElement submit;

    @FindBy(xpath = "/html/body/nav/div/ul[2]/a")
    private WebElement logout;

    @FindBy (xpath = "//html/body/nav/div/ul[2]/a")
    private WebElement logoutAfterRegistration;

    @FindBy (id = "username.errors")
    private WebElement usernameErrorMessage;

    @FindBy (id = "passwordConfirm.errors")
    private WebElement passwordDoesNotMatch;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateAccount() {
        createAccount.click();
    }

    public void enterNewUsername(String value) {
        createUsername.sendKeys(value);
    }

    public void enterNewPassword(String value) {
        createPassword.sendKeys(value);
    }

    public void confirmPassword(String value) {
        confirmPassword.sendKeys(value);
    }

    public void submitRegistration() {
        submit.click();
    }

    public void clickLogoutAfterRegistration() {
        logoutAfterRegistration.click();
    }

    public String showErrorMessageIfUserIsNotValid() {
        String errorMessageIfUserIsNotValid = usernameErrorMessage.getText();
        return errorMessageIfUserIsNotValid;
    }

    public String showErrorMessageIfPasswordDoesNotMatch() {
        String errorMessageIfPasswordDoesNotMatch = passwordDoesNotMatch.getText();
        return errorMessageIfPasswordDoesNotMatch;
    }

}
