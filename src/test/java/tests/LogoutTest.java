package tests;

import driver.DriverManagerNonSingleton;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.*;
import properties.TestProperties;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.DisplayName.class)
@Feature("Logout Features")
public class LogoutTest extends SuperTest{
//    DriverManagerNonSingleton driverManager;
//    WebDriver driver;
//    HomePage homePage;
//    LoginPage loginPage;


//    @BeforeEach
//    public void OpenURL() {
//        try {
//            driver.get(TestProperties.APP_URL);
//        } catch (TimeoutException e) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("return window.stop");
//        }
//        driver.switchTo().window(driver.getWindowHandle());
//    }
//
//    @AfterEach
//    public void quitTest() {
//        driverManager.quitDriver();
//
//    }

    @DisplayName("Logout User")
    @ParameterizedTest(name = "Email:''{0}'', Password:''{1}''")
    @CsvSource({
            TestProperties.VALID_LOGIN_EMAIL + "," + TestProperties.VALID_PASSWORD,
    })
    public void shouldLogoutTest(String userEmail, String password) {
        pages.getHomePage().selectSignUpLogin();
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
        pages.getLoginPage().enterLoginDetails(userEmail, password);
        pages.getHomePage().isLoggedIn();
        assertEquals("Automation Exercise", driver.getTitle());
        pages.getHomePage().selectLogoutBtn();
        assertTrue(!pages.getHomePage().isLoggedIn());
    }
}
