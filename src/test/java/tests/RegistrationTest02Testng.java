package tests;

import org.testng.annotations.*;
import properties.TestProperties;

import static org.testng.Assert.*;


//@Feature("Registration Features")
//@Tag("Parallel_Test")
public class RegistrationTest02Testng extends SuperTestTestng{

//    @DisplayName("1.Registration Success")
    @Test
//    @Story("User tries to register")
//    @Description("Register with correct credentials")
//    @Tag("Parallel_Test") ---- example
    public void successfulRegistrationTest()  {

        pages.getHomePage().selectSignUpLogin();
        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
        pages.getLoginPage().signUpEmail(TestProperties.VALID_REGISTRATION_USERNAME, TestProperties.VALID_REGISTRATION_EMAIL);
        assertEquals("Automation Exercise - Signup", driver.getTitle(), "This email is already registered");
        pages.getSignup().fillInRegistration();
        assertTrue(pages.getAccountCreated().isAccountCreated());
        pages.getAccountCreated().completeRegistration();

        pages.getHomePage().clickDeleteAccount();
        pages.getDeleteAccount().completeAccountDeletion();


    }


//    @DisplayName("2.Registration Fail")
//    @ParameterizedTest(name = "Username:''{0}'',Email:''{1}''")
////    @ValueSource(strings = {"123", "123@"}) ---- not used
//
//    @CsvSource({TestProperties.VALID_REGISTRATION_USERNAME + "," + TestProperties.INVALID_EMAIL,
//            TestProperties.VALID_REGISTRATION_USERNAME + "," + TestProperties.VALID_LOGIN_EMAIL})
//    @Story("User tries to register")
//    @Description("Register with incorrect credentials")
//    public void failRegistrationTest(String userName, String email) {
//
//        pages.getHomePage().selectSignUpLogin();
//        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
//        pages.getLoginPage().signUpEmail(userName, email);
//        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
//
//
//
//    }


}
