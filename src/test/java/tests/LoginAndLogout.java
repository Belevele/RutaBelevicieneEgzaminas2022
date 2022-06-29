package tests;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginAndLogout extends BaseTest {

    private LoginPage loginPage;

    /**
     * Positive testcase to check Login page
     * LOGIN WITH EXISTING USER
     *
     * Steps:
     * Open web application
     * Enter valid values to the required fields
     * Click login
     * Check if username is displayed
     * Logout
     * Check if message about successful logout is displayed
     */

    @Test(groups = { "UI" })
    public void loginExistingUser() {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername("ruta999");
        loginPage.enterPassword("rutaruta");
        loginPage.clickLogin();
        assertEquals(loginPage.findLoggedUserName(), "Logout, ruta999");
        loginPage.clickLogout();
        assertEquals((loginPage.showMessageIfLogoutWasSuccessful()), "Sėkmingai atsijungėte");
    }

    /**
     * Negative testcase to check Login page
     * LOGIN WITH NON-EXISTING USER
     *
     * Steps:
     * Open web application
     * Enter valid values to the required fields
     * Click login
     * Check error message
     */


    @Test(groups = { "UI" })
    public void loginWithInvalidUser() {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername("ruta555");
        loginPage.enterPassword("rutaruta");
        loginPage.clickLogin();
        assertEquals(loginPage.showErrorMessageIfUserIsNotValid(), "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi");

    }
}




