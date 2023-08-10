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
public class ContactUsTest{
    DriverManagerNonSingleton driverManager;
    WebDriver driver;
    HomePage homePage;
    ContactUs contactUs;



    public ContactUsTest() throws InterruptedException {

        driverManager = new DriverManagerNonSingleton("chrome");
        driver = driverManager.getDriver();
        homePage = new HomePage(driver);
        contactUs = new ContactUs(driver);
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

    @DisplayName("Contact Us Form")
    @Test
    public void shouldContactUs(){
        homePage.selectContactUsBtn();
        assertTrue(contactUs.isInContactUsPage(),"Not in Contact Us Page");
        contactUs.fillInContactUsForm();


    }
}
