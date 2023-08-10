package driver.example;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class Main {
    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
       // homePage.goToURL("https://www.google.com");
        System.out.println("Hello world!");
    }
}