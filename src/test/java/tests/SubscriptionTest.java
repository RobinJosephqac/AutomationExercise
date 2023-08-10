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
public class SubscriptionTest{

DriverManagerNonSingleton driverManagerNonSingleton;
WebDriver driver;
    HomePage homePage;
    Cart cart;

    public SubscriptionTest() {
        homePage = new HomePage(driver);
        cart = new Cart(driver);
    }

    @DisplayName("Subscription Test @ homepage")
    @Test
    @Story("Verify Subscription in homepage")
    @Description("Subscribe with email @ homepage")

    public void subscriptionInHomepage(){
        homePage.verifySubscriptionTextExists();
        homePage.enterSubscriptionEmail(TestProperties.VALID_LOGIN_EMAIL);
        assertEquals(homePage.isSubscribed(), true);
    }

    @DisplayName("Subscription Test @ cart page")
    @Test
    @Story("Verify Subscription in cart page")
    @Description("Subscribe with email @ cart page")

    public void subscriptionInCartpage(){
        homePage.goToCartPage();
        assertEquals("Automation Exercise - Checkout",driver.getTitle());
        cart.verifySubscriptionTextExists();
        cart.enterSubscriptionEmail(TestProperties.VALID_LOGIN_EMAIL);
        assertEquals(cart.isSubscribed(), true);
    }

}
