package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs extends Page{

    private static By H2_HEADING = By.xpath("//div[contains(@class,'contact-form')]//h2");
    private static By NAME_FIELD = By.xpath("//input[@data-qa='name']");
    private static By EMAIL_FIELD = By.xpath("//input[@data-qa='email']");
    private static By SUBJECT_FIELD = By.xpath("//input[@data-qa='subject']");
    private static By MESSAGE_FIELD = By.xpath("//input[@data-qa='message']");
    private static By UPLOAD_BTN = By.xpath("//input[@name='upload_file']");
    public ContactUs(WebDriver driver) {
        super(driver);
    }

    public boolean isInContactUsPage(){
        return driver.findElement(H2_HEADING).getText().equals("GET IN TOUCH");
    }

    public void fillInContactUsForm(){
        typeInput(NAME_FIELD,"Robin");
        typeInput(EMAIL_FIELD,"123@gmail.com");



    }
}
