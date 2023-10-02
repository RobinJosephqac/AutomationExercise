package tests;

import driver.DriverManagerNonSingleton;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import pages.*;
import properties.TestProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.DisplayName.class)

@Feature("Subscription Features")
//@Tag("Parallel_Test")
public class SubscriptionTest extends SuperTest{

//DriverManagerNonSingleton driverManagerNonSingleton;
//WebDriver driver;
//    HomePage homePage;
//    Cart cart;





    @DisplayName("Subscription Test @ homepage")
    @Test
    @Story("Verify Subscription in homepage")
    @Description("Subscribe with email @ homepage")

    public void subscriptionInHomepage(){

//        DriverManagerNonSingleton driverManager = new DriverManagerNonSingleton("chrome");
//        WebDriver driver = driverManager.getDriver();
//        HomePage homePage = new HomePage(driver);
//
//        OpenURL(driver);

        pages.getHomePage().verifySubscriptionTextExists();
        pages.getHomePage().enterSubscriptionEmail(TestProperties.VALID_LOGIN_EMAIL);
        assertEquals(pages.getHomePage().isSubscribed(), true);

        driverManager.quitDriver();
    }

    @DisplayName("Subscription Test @ cart page")
    @Test
    @Story("Verify Subscription in cart page")
    @Description("Subscribe with email @ cart page")

    public void subscriptionInCartpage(){


        pages.getHomePage().goToCartPage();
        assertEquals("Automation Exercise - Checkout",driver.getTitle());
        pages.getCart().verifySubscriptionTextExists();
        pages.getCart().enterSubscriptionEmail(TestProperties.VALID_LOGIN_EMAIL);
        assertEquals(pages.getCart().isSubscribed(), true);

        driverManager.quitDriver();
    }

}
