package tests;

import driver.DriverManagerNonSingleton;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.Manager.PageObjectManager;
import properties.TestProperties;

public class SuperTest {
    DriverManagerNonSingleton driverManager;
    WebDriver driver;
    PageObjectManager pages;

//    public SuperTest() {
//
//       driverManager = new DriverManagerNonSingleton("chrome");
//        driver = driverManager.getDriver();
//    }

//    @BeforeEach
    public void OpenURL(WebDriver driver) {
        try {
            driver.get(TestProperties.APP_URL);
        } catch (TimeoutException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return window.stop");
        }
        //NO LONGER NEEDED TO SWITCH
         driver.switchTo().window(driver.getWindowHandle());

    }

    @BeforeEach
    public void BeforeTheTests(){
        driverManager = new DriverManagerNonSingleton(TestProperties.BROWSER);
        driver = driverManager.getDriver();
        pages = new PageObjectManager(driver);

        OpenURL(driver);
    }

    @AfterEach
    public void AfterTheTests(){
        driverManager.quitDriver();
    }
}
