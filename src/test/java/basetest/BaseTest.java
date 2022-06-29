package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite(groups = { "UI" })
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod(groups = { "UI" })
    public void openHomePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080");
    }
//
//    @AfterMethod(groups = { "UI" })
//    public void closeBrowser() {
//        driver.manage().deleteAllCookies();
//        driver.close();
//    }
//
//    @AfterSuite(groups = { "UI" })
//    public void quitDriver() {
//        driver.quit();
//    }
}