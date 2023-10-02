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
import pages.Manager.PageObjectManager;
import properties.TestProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.DisplayName.class)
@Feature("Login Features")
@Tag("Parallel_Test")
public class LoginTest extends SuperTest{

//    DriverManagerNonSingleton driverManager;
//    WebDriver driver;
//    PageObjectManager pages;
//
//

//
//    @BeforeEach
//    public void BeforeTheTests(){
//        driverManager = new DriverManagerNonSingleton(TestProperties.BROWSER);
//        driver = driverManager.getDriver();
//        pages = new PageObjectManager(driver);
//
//        OpenURL(driver);
//    }
//
//    @AfterEach
//    public void AfterTheTests(){
//        driverManager.quitDriver();
//    }



    @DisplayName("1.Login Success")
    @ParameterizedTest(name = "Email:''{0}'', Password:''{1}''")
    @CsvSource({
            TestProperties.VALID_LOGIN_EMAIL + "," + TestProperties.VALID_PASSWORD,
    })

    public void successfulLoginTest(String userEmail, String password) {


        pages.getHomePage().selectSignUpLogin();
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
        pages.getLoginPage().enterLoginDetails(userEmail, password);
        pages.getHomePage().isLoggedIn();
        assertEquals("Automation Exercise", driver.getTitle());
        pages.getHomePage().selectLogoutBtn();


    }


    @DisplayName("2.Login Fail")
    @ParameterizedTest(name = "email:''{0}'', password:''{1}''")
    @CsvSource({
            TestProperties.VALID_REGISTRATION_EMAIL + "," + TestProperties.INVALID_PASSWORD,
            TestProperties.INVALID_EMAIL + "," + TestProperties.VALID_PASSWORD,

    })
    public void failingLoginTest(String userEmail, String password) {


        pages.getHomePage().selectSignUpLogin();
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
        pages.getLoginPage().enterLoginDetails(userEmail, password);
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());

    }

}
