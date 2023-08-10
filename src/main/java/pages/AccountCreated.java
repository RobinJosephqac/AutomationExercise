package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreated extends Page {

    private static By H2_TAG = By.xpath("//h2//b[text()='Account Created!']");
    public static By CONTINUE_BUTTON = By.xpath("//a[text()='Continue']");

    public AccountCreated(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreated() {
//        System.out.println(driver.findElement(H2_TAG).getText());
        return driver.findElements(H2_TAG).size() == 1;
    }
    public void completeRegistration(){
        clickElement(CONTINUE_BUTTON);
    }
}
