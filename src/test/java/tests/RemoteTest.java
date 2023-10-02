package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.Manager.PageObjectManager;
import properties.TestProperties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RemoteTest
{
    @Test
    public void setDriver(){
        WebDriver driver;
        final String CONFIG_WEBDRIVER_CHROME_LOCATION = new File("C:\\QAC\\AutomationExerciseTrial02\\src\\main\\java\\driver", "chromedriver.exe").getPath();

        System.setProperty("webdriver.chrome.driver", CONFIG_WEBDRIVER_CHROME_LOCATION);
        ChromeOptions options02 = new ChromeOptions();
//        options02.addExtensions(new File("C:\\QAC\\SeleniumWebDriver_IntelliJDemo\\src\\main\\java\\driver\\adBlock\\gighmmpiobklfepjocnamgkkbiglidom-5.4.1-Crx4Chrome.com.crx"));


        options02.setCapability("browserVersion", "116.0");;
        options02.setCapability("platformName", "Windows 10");

//        options02.addArguments("--remote-allow-origins=*");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options02);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        PageObjectManager pages = new PageObjectManager(driver);

        driver.get("http://www.google.com");
        driver.quit();


//        pages.getHomePage().selectSignUpLogin();
//        assertEquals("Automation Exercise - Signup / Login", driver.getTitle());
//        pages.getLoginPage().signUpEmail(TestProperties.VALID_REGISTRATION_USERNAME, TestProperties.VALID_REGISTRATION_EMAIL);
//        assertEquals("Automation Exercise - Signup", driver.getTitle(), "This email is already registered");
//        pages.getSignup().fillInRegistration();
//        assertTrue(pages.getAccountCreated().isAccountCreated());
//        pages.getAccountCreated().completeRegistration();
//
//        pages.getHomePage().clickDeleteAccount();
//        pages.getDeleteAccount().completeAccountDeletion();
    }

}
