package tests;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.PageObjectManager;
import properties.TestProperties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;


public class DockerTest {

    RemoteWebDriver driver2;
    PageObjectManager pages;



    public void OpenURL(WebDriver driver2) {
        try {
            driver2.get(TestProperties.APP_URL);
        } catch (TimeoutException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver2;
            js.executeScript("return window.stop");
        }
        //NO LONGER NEEDED TO SWITCH
        driver2.switchTo().window(driver2.getWindowHandle());

    }



    @Test
    public void DockerFirefoxTest() throws MalformedURLException{
        FirefoxOptions options04 = new FirefoxOptions();
        options04.addArguments("--no-sandbox");
        // options03.addArguments("--headless");
        options04.addArguments("--disable-dev-shm-usage");
//    options03.setCapability("browserVersion", "115.0");;
//    options03.setCapability("platformName", "Windows 10");


        URL url = new URL("http://localhost:4444/wd/hub");

        driver2 = new RemoteWebDriver(url,options04);
        driver2.get("http://amazon.ca");
        System.out.println(driver2.getTitle());
        Assert.assertEquals(driver2.getTitle(),"Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
        System.out.println(driver2.getCapabilities());
        driver2.quit();
    }
    @Test
    public void successfulRegistrationTest() throws MalformedURLException {

        ChromeOptions options04 = new ChromeOptions ();
        options04.addExtensions(new File("C:\\QAC\\SeleniumWebDriver_IntelliJDemo\\src\\main\\java\\driver\\adBlock\\gighmmpiobklfepjocnamgkkbiglidom-5.4.1-Crx4Chrome.com.crx"));

        options04.addArguments("--no-sandbox");
        // options03.addArguments("--headless");
        options04.addArguments("--disable-dev-shm-usage");
        URL url = new URL("http://localhost:4444/wd/hub");
        driver2 = new RemoteWebDriver(url,options04);
        pages = new PageObjectManager(driver2);

        OpenURL(driver2);

        pages.getHomePage().selectSignUpLogin();
        Assert.assertEquals( driver2.getTitle(),"Automation Exercise - Signup / Login");
        pages.getLoginPage().signUpEmail(TestProperties.VALID_REGISTRATION_USERNAME, TestProperties.VALID_REGISTRATION_EMAIL);
        Assert.assertEquals(driver2.getTitle(),"Automation Exercise - Signup", "This email is already registered");
        pages.getSignup().fillInRegistration();
        Assert.assertTrue(pages.getAccountCreated().isAccountCreated());
        pages.getAccountCreated().completeRegistration();

        //System.out.println(driver2.getPageSource());     //for testing

        pages.getHomePage().clickDeleteAccount();
        pages.getDeleteAccount().completeAccountDeletion();
        driver2.quit();

    }

    @Test
    public void shouldContactUs() throws MalformedURLException {

        ChromeOptions options04 = new ChromeOptions ();
        options04.addExtensions(new File("C:\\QAC\\SeleniumWebDriver_IntelliJDemo\\src\\main\\java\\driver\\adBlock\\gighmmpiobklfepjocnamgkkbiglidom-5.4.1-Crx4Chrome.com.crx"));

        options04.addArguments("--no-sandbox");
        // options03.addArguments("--headless");
        options04.addArguments("--disable-dev-shm-usage");
        URL url = new URL("http://localhost:4444/wd/hub");
        driver2 = new RemoteWebDriver(url,options04);
        pages = new PageObjectManager(driver2);

        OpenURL(driver2);
        pages.getHomePage().selectContactUsBtn();
        assertTrue(pages.getContactUs().isInContactUsPage(),"Not in Contact Us Page");
        pages.getContactUs().fillInContactUsForm();
        driver2.quit();

    }
//    @Test
//    public void successfulLoginTest() throws MalformedURLException {
//
//        ChromeOptions options04 = new ChromeOptions ();
//        options04.addExtensions(new File("C:\\QAC\\SeleniumWebDriver_IntelliJDemo\\src\\main\\java\\driver\\adBlock\\gighmmpiobklfepjocnamgkkbiglidom-5.4.1-Crx4Chrome.com.crx"));
//
//        options04.addArguments("--no-sandbox");
//        // options03.addArguments("--headless");
//        options04.addArguments("--disable-dev-shm-usage");
//        URL url = new URL("http://localhost:4444/wd/hub");
//        driver2 = new RemoteWebDriver(url,options04);
//        pages = new PageObjectManager(driver2);
//
//        OpenURL(driver2);
//        pages.getHomePage().selectSignUpLogin();
//        assertEquals("Automation Exercise - Signup / Login", driver2.getTitle());
//        pages.getLoginPage().enterLoginDetails(TestProperties.VALID_LOGIN_EMAIL, TestProperties.VALID_PASSWORD);
//        pages.getHomePage().isLoggedIn();
//        assertEquals("Automation Exercise", driver2.getTitle());
//        pages.getHomePage().selectLogoutBtn();
//
//
//    }
//
//    @Test
//    public void shouldLogoutTest() throws MalformedURLException {
//
//        ChromeOptions options04 = new ChromeOptions ();
//        options04.addExtensions(new File("C:\\QAC\\SeleniumWebDriver_IntelliJDemo\\src\\main\\java\\driver\\adBlock\\gighmmpiobklfepjocnamgkkbiglidom-5.4.1-Crx4Chrome.com.crx"));
//
//        options04.addArguments("--no-sandbox");
//        // options03.addArguments("--headless");
//        options04.addArguments("--disable-dev-shm-usage");
//        URL url = new URL("http://localhost:4444/wd/hub");
//        driver2 = new RemoteWebDriver(url,options04);
//        pages = new PageObjectManager(driver2);
//
//        OpenURL(driver2);
//
//        pages.getHomePage().selectSignUpLogin();
//        assertEquals("Automation Exercise - Signup / Login", driver2.getTitle());
//        pages.getLoginPage().enterLoginDetails(TestProperties.VALID_LOGIN_EMAIL, TestProperties.VALID_PASSWORD);
//        pages.getHomePage().isLoggedIn();
//        assertEquals("Automation Exercise", driver2.getTitle());
//        pages.getHomePage().selectLogoutBtn();
//        assertTrue(!pages.getHomePage().isLoggedIn());
//    }
//
//    @Test
//    public void subscriptionInHomepage() throws MalformedURLException {
//
//        ChromeOptions options04 = new ChromeOptions ();
//        options04.addExtensions(new File("C:\\QAC\\SeleniumWebDriver_IntelliJDemo\\src\\main\\java\\driver\\adBlock\\gighmmpiobklfepjocnamgkkbiglidom-5.4.1-Crx4Chrome.com.crx"));
//
//        options04.addArguments("--no-sandbox");
//        // options03.addArguments("--headless");
//        options04.addArguments("--disable-dev-shm-usage");
//        URL url = new URL("http://localhost:4444/wd/hub");
//        driver2 = new RemoteWebDriver(url,options04);
//        pages = new PageObjectManager(driver2);
//
//        OpenURL(driver2);
//
//        pages.getHomePage().verifySubscriptionTextExists();
//        pages.getHomePage().enterSubscriptionEmail(TestProperties.VALID_LOGIN_EMAIL);
//        assertEquals(pages.getHomePage().isSubscribed(), true);
//
//        driver2.quit();
//    }

}
