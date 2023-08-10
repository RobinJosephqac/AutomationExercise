package driver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;


public class DriverManagerNonSingleton {
    private static WebDriver driver;


    public DriverManagerNonSingleton(String browserName) {
        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addExtensions(new File("C:\\QAC\\SeleniumWebDriver_IntelliJDemo\\src\\main\\java\\driver\\adBlock\\gighmmpiobklfepjocnamgkkbiglidom-5.4.1-Crx4Chrome.com.crx"));

                // change to a specific chrome profile that has the adblock extension installed
               chromeOptions.setBrowserVersion("114");
//                chromeOptions.addArguments("user-data-dir=C:\\Users\\raugustine\\AppData\\Local\\Google\\Chrome\\User Data Automation");
//                chromeOptions.addArguments("profile-directory=Profile 4");

                chromeOptions.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(chromeOptions);
                System.out.println(driver.getWindowHandles());

                WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(30));
                wait.until(ExpectedConditions.numberOfWindowsToBe(2));
                System.out.println(driver.getWindowHandles());
                ArrayList<String> handlesArray = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(handlesArray.get(1));
                wait.until(ExpectedConditions.textToBe(By.id("title"),"The honor system"));

                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
// Here you set the path of the profile ending with User Data not the profile folder
               edgeOptions.addArguments("user-data-dir=C:\\Users\\raugustine\\AppData\\Local\\Microsoft\\Edge\\User Data Automation");

// Here you specify the actual profile folder
               edgeOptions.addArguments("profile-directory=Profile 1");

                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);
                break;

        }

    }

    public WebDriver getDriver() {
        //TODO: initialize driver passing browserName as arg
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}