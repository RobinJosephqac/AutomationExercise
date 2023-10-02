package pages.Manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {

    WebDriver driver;
    HomePage homePage;
    AccountCreated accountCreated;
    Cart cart;
    ContactUs contactUs;
    DeleteAccount deleteAccount;
    LoginPage loginPage;

    ProductsPage productsPage;
    Signup signup;


    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public AccountCreated getAccountCreated() {
        return (accountCreated == null) ? accountCreated = new AccountCreated(driver) : accountCreated;
    }

    public Cart getCart() {
        return (cart == null) ? cart = new Cart(driver) : cart;
    }

    public ContactUs getContactUs() {
        return (contactUs == null) ? contactUs = new ContactUs(driver) : contactUs;
    }

    public DeleteAccount getDeleteAccount() {
        return (deleteAccount == null) ? deleteAccount = new DeleteAccount(driver) : deleteAccount;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }


    public ProductsPage getProductsPage() {
        return (productsPage == null) ? productsPage = new ProductsPage(driver) : productsPage;
    }

    public Signup getSignup() {
        return (signup == null) ? signup = new Signup(driver) : signup;
    }
}
