package tests;

import driver.DriverManagerNonSingleton;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import pages.*;
import io.qameta.allure.*;



import properties.TestProperties;


import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.DisplayName.class)67

@Feature("Registration Features")
public class RegistrationTest {


//    DriverManagerNonSingleton driverManager;
//    WebDriver driver;
//    String title;
//    LoginPage loginPage;
//    HomePage homePage;
//    Signup signup;
//    AccountCreated accountCreated;
//    DeleteAccount deleteAccount;
    // path where output is to be printed





//    public RegistrationTest() {
//
//
//
//    }


//    @BeforeEach
    public void OpenURL(WebDriver driver) {
        try {
            driver.get(TestProperties.APP_URL);
        } catch (TimeoutException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return window.stop");
        }
        driver.switchTo().window(driver.getWindowHandle());

    }



    @DisplayName("1.Registration Success")
    @Test
    @Story("User tries to register")
    @Description("Register with correct credentials")
    public void successfulRegistrationTest()  {
        DriverManagerNonSingleton driverManager = new DriverManagerNonSingleton("chrome");
        WebDriver driver = driverManager.getDriver();

        LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);
        Signup signup = new Signup(driver);
        AccountCreated accountCreated = new AccountCreated(driver);
        DeleteAccount deleteAccount = new DeleteAccount(driver);

        OpenURL(driver);
        homePage.selectSignUpLogin();
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
        loginPage.signUpEmail(TestProperties.VALID_REGISTRATION_USERNAME, TestProperties.VALID_REGISTRATION_EMAIL);
        assertEquals("Automation Exercise - Signup", driver.getTitle(), "This email is already registered");
        signup.fillInRegistration();
        assertEquals(accountCreated.isAccountCreated(), true);
        accountCreated.completeRegistration();

        homePage.clickDeleteAccount();
        deleteAccount.completeAccountDeletion();

            driver.quit();
    }

    @DisplayName("2.Registration Fail")
    @ParameterizedTest(name = "Username:''{0}'',Email:''{1}''")
//    @ValueSource(strings = {"123", "123@"})

    @CsvSource({TestProperties.VALID_REGISTRATION_USERNAME + "," + TestProperties.INVALID_EMAIL,
            TestProperties.VALID_REGISTRATION_USERNAME + "," + TestProperties.VALID_LOGIN_EMAIL})
    @Story("User tries to register")
    @Description("Register with incorrect credentials")
    public void failRegistrationTest(String userName, String email) throws InterruptedException {

        DriverManagerNonSingleton driverManager = new DriverManagerNonSingleton("chrome");
        WebDriver driver = driverManager.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        OpenURL(driver);

        homePage.selectSignUpLogin();
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
        loginPage.signUpEmail(userName, email);
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
//        driverManager.quitDriver();
            driver.quit();
    }


}
