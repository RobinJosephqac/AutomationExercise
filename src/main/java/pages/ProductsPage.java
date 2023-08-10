package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends Page{

    private static final By SEARCH_PRODUCT_TXTBOX = By.xpath("//input[@name='search']");
    private static final By SUBMIT_SEARCH_BUTTON = By.xpath("//button[@id='submit_search']");
    public ProductsPage(WebDriver driver) {
        super(driver); // new Page(driver)

    }


    public void selectAProductToView(String product){
    By PRODUCT_TO_VIEW = By.xpath(String.format("//p[text()='%s']/ancestor::div[@class='product-image-wrapper']//a[contains(@href,'/product_details')]",product));
    clickElement(PRODUCT_TO_VIEW);
    }


    public void selectAProductToSearchFor(String product){
        typeInput(SEARCH_PRODUCT_TXTBOX,product);
        clickElement(SUBMIT_SEARCH_BUTTON);

    }

    public boolean onlySearchedProductIsDisplayed(String product) {
        By searchedItems = By.xpath("//div[@class='features_items']//div[@class='col-sm-4']");
        int searchSize = driver.findElements(searchedItems).size();
        for(int i =1;i<searchSize+1;i++){
            By searchItem = By.xpath(String.format("//div[@class='features_items']//div[@class='col-sm-4']["+i+"]//div[@class='productinfo text-center']//p[contains(text(),'"+product+"')]"));
           if(!elementExists(searchItem)){
               return false;
           }
        }
        return true;
    }
}
