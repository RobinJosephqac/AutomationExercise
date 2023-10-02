package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DockerChromeStandaloneTest {
    @Test
    public void DockerChromeTest() throws MalformedURLException{
    //    DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

    //    final String CONFIG_WEBDRIVER_CHROME_LOCATION = new File("C:\\QAC\\AutomationExerciseTrial02\\src\\main\\java\\driver", "chromedriver.exe").getPath();

    //    System.setProperty("webdriver.chrome.driver", CONFIG_WEBDRIVER_CHROME_LOCATION);
        ChromeOptions options03 = new ChromeOptions();
        options03.addArguments("--no-sandbox");
       // options03.addArguments("--headless");
        options03.addArguments("--disable-dev-shm-usage");

    //--------------- firefox options-----------------
        FirefoxOptions options04 = new FirefoxOptions();
        options04.addArguments("--no-sandbox");
        // options03.addArguments("--headless");
        options04.addArguments("--disable-dev-shm-usage");
    //    options03.setCapability("browserVersion", "115.0");;
    //    options03.setCapability("platformName", "Windows 10");


        URL url = new URL("http://localhost:4444/wd/hub");

        RemoteWebDriver driver = new RemoteWebDriver(url,options03);
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Gogle");
        System.out.println(driver.getCapabilities());
        driver.quit();


    }
}
