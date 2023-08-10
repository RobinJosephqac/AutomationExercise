package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signup extends Page{

    private static By PASSWORD = By.id("password");
    private static By FIRST_NAME = By.id("first_name");
    private static By LAST_NAME = By.id("last_name");
    private static By ADDRESS1 = By.id("address1");
    private static By STATE = By.id("state");
    private static By CITY = By.id("city");
    private static By ZIPCODE = By.id("zipcode");
    private static By MOBILE_NO = By.id("mobile_number");

    public Signup(WebDriver driver) {
        super(driver);
    }

    public void fillInRegistration(){
        typeInput(PASSWORD,"123456");
        typeInput(FIRST_NAME,"Robin");
        typeInput(LAST_NAME,"Augustine");
        typeInput(ADDRESS1,"Kumplankal House");
        typeInput(STATE,"Kerala");
        typeInput(CITY,"Pala");
        typeInput(ZIPCODE,"686651");
        typeInput(MOBILE_NO,"7012705794");

    }
}
