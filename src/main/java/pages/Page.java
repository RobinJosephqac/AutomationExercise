package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
    public WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
    public void typeInput(By by, String input) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(input);
        element.sendKeys(Keys.RETURN);
    }

    public void clickElement(By by){
        WebElement element = driver.findElement(by);

        element.click();
    }
    public boolean elementExists(By byLocator) {
        return driver.findElements(byLocator).size() > 0;
    }
}
