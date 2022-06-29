package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractObjectPage {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "/html/body/div/form/div/button")
    private WebElement login;

    @FindBy(xpath = "/html/body/nav/div/ul[2]/a")
    private WebElement logout;

    @FindBy(xpath = "/html/body/div/form/div/span[2]")
    private WebElement messageIfUserIsNotValid;

//    @FindBy(xpath = "/html/body/div/h2/a")
//    private WebElement logout;
//


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String value) {
        username.sendKeys(value);
    }

    public void enterPassword(String value) {
        password.sendKeys(value);
    }

    public void clickLogin() {
        login.click();
    }

    public String findLoggedUserName() {
        String logoutPlusUserName = logout.getText();
        return logoutPlusUserName;
    }

    public void clickLogout() {
        logout.click();
    }

    public String showErrorMessageIfUserIsNotValid() {
        String errorMessage = messageIfUserIsNotValid.getText();
        return errorMessage;
    }

}