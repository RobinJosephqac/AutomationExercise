package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page{
    public static final By SIGNUP_LOGIN_TAB = By.xpath("//a[contains(text(),' Signup')]");
    private static final By DELETE_ACCOUNT_BTN = By.xpath("//a[@href='/delete_account']");
    private static final By LOGOUT_BTN = By.xpath("//a[@href='/logout']");
    private static final By CONTACT_US_BTN = By.xpath("//a[@href='/contact_us']");
    private static final By TEST_CASES_BTN = By.xpath("//header//a[@href='/test_cases']");
    private static final By PRODUCTS_BTN = By.xpath("//a[@href='/products']");
    private static final By SUBSCRIBE_WITH_EMAIL = By.xpath("//input[@id='susbscribe_email']");
    private static final By ENTER_SUBSCRIBE_BUTTON = By.xpath("//button[@id='subscribe']");
    private static final By SUBSCRIPTION_ALERT = By.xpath("//div[text()='You have been successfully subscribed!']");
    private static final By CART_BUTTON = By.xpath("//div[contains(@class,'shop')]//a[@href='/view_cart']");
    private WebDriver driver1;
    public HomePage(WebDriver driver) {
        super(driver); // new Page(driver)
        driver1 = driver;
    }

    public void goToURL(String url){
        driver1.get(url);
    }

    public void selectSignUpLogin(){
        clickElement(SIGNUP_LOGIN_TAB);
    }

    public void clickDeleteAccount(){
        clickElement(DELETE_ACCOUNT_BTN);
    }
    public boolean isLoggedIn(){
        return elementExists(LOGOUT_BTN);
    }

    public void selectLogoutBtn() {
        clickElement(LOGOUT_BTN);
    }
    public void selectContactUsBtn(){
        clickElement(CONTACT_US_BTN);
    }

    public void selectTestCasesTab() {
        clickElement(TEST_CASES_BTN);
    }

    public void selectProductsTab() throws IllegalMonitorStateException {
        clickElement(PRODUCTS_BTN);
    }

    public void verifySubscriptionTextExists() {
        elementExists(By.xpath("//h2[text()='Subscription']"));
    }

    public void enterSubscriptionEmail(String emailId){
        typeInput(SUBSCRIBE_WITH_EMAIL,emailId);
        clickElement(ENTER_SUBSCRIBE_BUTTON);
    }

    public boolean isSubscribed() {
        return driver.findElement(SUBSCRIPTION_ALERT).isDisplayed();
    }

    public void goToCartPage(){
        clickElement(CART_BUTTON);
    }
}

