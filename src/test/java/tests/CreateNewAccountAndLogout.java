package tests;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.CreateAccountPage;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

public class CreateNewAccountAndLogout extends BaseTest {

    private CreateAccountPage createAccountPage;

    /**
     * Positive testcase to check Account Creation Page
     * SUCCESSFULLY CREATE NEW ACCOUNT
     *
     * Steps:
     * Open web application
     * Enter valid values to the required fields
     * Click submit
     * Logout
     */

    @Test(groups = { "UI" })
    public void createAccount() {
        createAccountPage = new CreateAccountPage(driver);

        String newUsername = new Random().nextInt(1000) + "test@gmail.com";
        String password = "nesakysiu";
        String confirmPassword = "nesakysiu";

        createAccountPage.clickCreateAccount();
        createAccountPage.enterNewUsername(newUsername);
        createAccountPage.enterNewPassword(password);
        createAccountPage.confirmPassword(confirmPassword);
        createAccountPage.submitRegistration();
        createAccountPage.clickLogoutAfterRegistration();
    }

    /**
     * Negative testcase to check Account Creation Page
     * CREATE NEW ACCOUNT WITH EXISTING USERNAME
     *
     * Steps:
     * Open web application
     * To the "Prisijungimo vardas" field enter existing username
     * Enter the same passwords to the "Slaptazodis" and "Slaptazodzio patvirtinimas" fields
     * Click "Prisijungti"
     * Check if correct error message is displayed
     */

    @Test(groups = { "UI" })
    public void tryToCreateAccountWithExistingUsername() {

        createAccountPage = new CreateAccountPage(driver);

        createAccountPage.clickCreateAccount();
        createAccountPage.enterNewUsername("Tomas");
        createAccountPage.enterNewPassword("Tomas");
        createAccountPage.confirmPassword("Tomas");
        createAccountPage.submitRegistration();
        assertEquals(createAccountPage.showErrorMessageIfUserIsNotValid(), "Toks vartotojo vardas jau egzistuoja");
    }

    /**
     * Negative testcase to check Account Creation Page
     * CREATE NEW ACCOUNT WITH PASSWORDS THAT DON'T MATCH
     *
     * Steps:
     * Open web application
     * To the "Prisijungimo vardas" field enter valid username
     * Enter valid value to the "Slaptazodis" field
     * Enter valid value to the "Slaptazodzio patvirtinimas" field (the second password must not match the first one)
     * Click "Prisijungti"
     * Check if correct error message is displayed
     */

    @Test(groups = { "UI" })
    public void tryToCreateAccountWhenPasswordDoesNotMatch() {

        createAccountPage = new CreateAccountPage(driver);

        createAccountPage.clickCreateAccount();
        createAccountPage.enterNewUsername("OkisDokis");
        createAccountPage.enterNewPassword("Nesakysiu");
        createAccountPage.confirmPassword("Nesak");
        createAccountPage.submitRegistration();
        assertEquals(createAccountPage.showErrorMessageIfPasswordDoesNotMatch(), "Įvesti slaptažodžiai nesutampa");
    }
}
