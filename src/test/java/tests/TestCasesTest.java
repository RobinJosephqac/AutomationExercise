package tests;

import driver.DriverManagerNonSingleton;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import properties.TestProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.DisplayName.class)

@Feature("Test Cases Features")
public class TestCasesTest extends SuperTest{
//    DriverManagerNonSingleton driverManager;
//    WebDriver driver;
//    HomePage homePage;




    @DisplayName("Go to Test Cases Page")
    @Test
    @Story("User tries to go to test cases page")
    @Description("User tries to go to test cases page and verify that page is open")
    public void goToTestCasesPageTest() throws InterruptedException{
        pages.getHomePage().selectTestCasesTab();
        assertEquals("Automation Practice Website for UI Testing - Test Cases", driver.getTitle());

    }


}


