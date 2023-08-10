package tests;

import driver.DriverManagerNonSingleton;
import io.qameta.allure.Feature;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.*;
import properties.TestProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.DisplayName.class)
@Feature("Login Features")
public class LoginTest {
    DriverManagerNonSingleton driverManager;
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;


    public LoginTest() {

        driverManager = new DriverManagerNonSingleton("chrome");
        driver = driverManager.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @BeforeEach
    public void OpenURL() {
        try {
            driver.get(TestProperties.APP_URL);
        } catch (TimeoutException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return window.stop");
        }
        driver.switchTo().window(driver.getWindowHandle());
    }

    @AfterEach
    public void quitTest() {
        driverManager.quitDriver();
    }

    @DisplayName("1.Login Success")
    @ParameterizedTest(name = "Email:''{0}'', Password:''{1}''")
    @CsvSource({
            TestProperties.VALID_LOGIN_EMAIL + "," + TestProperties.VALID_PASSWORD,
    })
    public void successfulLoginTest(String userEmail, String password) {
        homePage.selectSignUpLogin();
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
        loginPage.enterLoginDetails(userEmail, password);
        homePage.isLoggedIn();
        assertEquals("Automation Exercise", driver.getTitle());
        homePage.selectLogoutBtn();
    }


    @DisplayName("2.Login Fail")
    @ParameterizedTest(name = "email:''{0}'', password:''{1}''")
    @CsvSource({
            TestProperties.VALID_REGISTRATION_EMAIL + "," + TestProperties.INVALID_PASSWORD,
            TestProperties.INVALID_EMAIL + "," + TestProperties.VALID_PASSWORD,

    })
    public void failingLoginTest(String userEmail, String password) {
        homePage.selectSignUpLogin();
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
        loginPage.enterLoginDetails(userEmail, password);
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
    }

}
