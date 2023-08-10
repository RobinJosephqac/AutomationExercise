package tests;

import driver.DriverManagerNonSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import properties.TestProperties;

public class SuperTest {
    DriverManagerNonSingleton driverManager;
    WebDriver driver;

    public SuperTest() {

        driverManager = new DriverManagerNonSingleton("chrome");
        driver = driverManager.getDriver();
    }

    @BeforeEach
    public void OpenURL() {
        try {
            driver.get(TestProperties.APP_URL);
        } catch (TimeoutException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return window.stop");
        }
        //NO LONGER NEEDED TO SWITCH
         driver.switchTo().window(driver.getWindowHandle());

    }

    @AfterEach
    public void quitTest() {
        driverManager.quitDriver();
    }
}
