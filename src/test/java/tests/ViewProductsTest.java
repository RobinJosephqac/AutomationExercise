package tests;

import driver.DriverManagerNonSingleton;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.*;
import properties.TestProperties;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewProductsTest extends SuperTest{

    String product = "Blue Top" ;


//
//    @BeforeEach
//    public void OpenURL() {
//        try {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.get(TestProperties.APP_URL);
//        } catch (TimeoutException e) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("return window.stop");
//        }
//        driver.switchTo().window(driver.getWindowHandle());
//
//    }
//
//    @AfterEach
//    public void quitTest() {
//        driverManager.quitDriver();
//    }

    @DisplayName("Go to Products Page")
    @Test
    @Story("User tries to go to Products page")
    @Description("User tries to go to Products page and view a product")
    public void goToProductsPageTest() throws InterruptedException{

        pages.getHomePage().selectProductsTab();
        assertEquals("Automation Exercise - All Products", driver.getTitle());
        pages.getProductsPage().selectAProductToView("Blue Top");
    }

    @DisplayName("Go to Products Page and search for a product")
    @Test
    @Story("User tries to go to Products page and search for a Blue Top")
    @Description("User tries to go to Products page and search a product to view")
    public void goToProductsPageAndSearchForProductTest() throws InterruptedException{

        pages.getHomePage().selectProductsTab();
        assertEquals("Automation Exercise - All Products", driver.getTitle());
        pages.getProductsPage().selectAProductToSearchFor(product);
        assertTrue(pages.getProductsPage().onlySearchedProductIsDisplayed(product),"Invalid search results");
    }


}
