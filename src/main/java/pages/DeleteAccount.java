package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccount extends Page{

    private static By CONTINUE_BTN = By.xpath("//a[contains(@data-qa,'continue-button')]");
    public DeleteAccount(WebDriver driver) {
        super(driver);
    }
    public void completeAccountDeletion(){
        clickElement(CONTINUE_BTN);
    }
}
