package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{
    private static By SIGNUP_NAME = By.xpath("//input[contains(@data-qa,'signup-name')]");
    private static By SIGNUP_EMAIL = By.xpath("//input[contains(@data-qa,'signup-email')]");
    private static By SIGNUP_BUTTON = By.xpath("//button[contains(@data-qa,'signup-button')]");
    private static By LOGIN_EMAIL = By.xpath("//input[contains(@data-qa,'login-email')]");
    private static By LOGIN_PASSWORD = By.xpath("//input[contains(@data-qa,'login-password')]");
    private static By Login_SUBMIT = By.xpath("//button[contains(@data-qa,'login-button')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void signUpEmail(String userName, String email){

        typeInput(SIGNUP_NAME,userName);
        typeInput(SIGNUP_EMAIL,email);
       // clickElement(SIGNUP_BUTTON);

    }
    public void enterLoginDetails(String userEmail, String password){
        typeInput(LOGIN_EMAIL,userEmail);
        typeInput(LOGIN_PASSWORD,password);
    }




}
