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

public class ViewProductsTest{
    DriverManagerNonSingleton driverManager;
    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    String product = "Blue Top" ;

    public  ViewProductsTest() {

        driverManager = new DriverManagerNonSingleton("chrome");
        driver= driverManager.getDriver();
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
    }
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

        homePage.selectProductsTab();
        assertEquals("Automation Exercise - All Products", driver.getTitle());
        productsPage.selectAProductToView("Blue Top");
    }

    @DisplayName("Go to Products Page and search for a product")
    @Test
    @Story("User tries to go to Products page and search for a Blue Top")
    @Description("User tries to go to Products page and search a product to view")
    public void goToProductsPageAndSearchForProductTest() throws InterruptedException{

        homePage.selectProductsTab();
        assertEquals("Automation Exercise - All Products", driver.getTitle());
        productsPage.selectAProductToSearchFor(product);
        assertTrue(productsPage.onlySearchedProductIsDisplayed(product),"Invalid search results");
    }


}
