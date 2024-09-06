package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchingMainPage {
    private WebDriver driver;
    private WebElement searchField;
    private WebElement noOfItems;

    public SearchingMainPage(WebDriver driver){
        this.driver=driver;
    }

    public void searchForItem(String item){
        searchField=driver.findElement(By.id("search"));
        searchField.sendKeys(item);
        searchField.sendKeys(Keys.ENTER);
    }

    public String getNoOfItems(){
        noOfItems = driver.findElement(By.id("toolbar-amount"));
        return noOfItems.getText();
    }
}
