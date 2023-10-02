package tests;

import driver.DriverManagerNonSingleton;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.*;
import properties.TestProperties;



import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.DisplayName.class)
@Feature("Contact Us Features")
public class ContactUsTest extends SuperTest{
//    DriverManagerNonSingleton driverManager;
//    WebDriver driver;
//    HomePage homePage;
//    ContactUs contactUs;



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

    @DisplayName("Contact Us Form")
    @Test
    public void shouldContactUs(){

        pages.getHomePage().selectContactUsBtn();
        assertTrue(pages.getContactUs().isInContactUsPage(),"Not in Contact Us Page");
        pages.getContactUs().fillInContactUsForm();


    }
}
