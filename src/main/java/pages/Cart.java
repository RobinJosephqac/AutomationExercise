package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends Page{
    private WebDriver driver1;
    private static final By SUBSCRIBE_WITH_EMAIL = By.xpath("//input[@id='susbscribe_email']");
    private static final By ENTER_SUBSCRIBE_BUTTON = By.xpath("//button[@id='subscribe']");
    private static final By SUBSCRIPTION_ALERT = By.xpath("//div[text()='You have been successfully subscribed!']");

    public Cart(WebDriver driver) {
        super(driver); // new Page(driver)
        driver1 = driver;
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
}
