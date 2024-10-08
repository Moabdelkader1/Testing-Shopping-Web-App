package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class HomePage {

    private WebDriver driver;
    private By signUpButton = By.linkText("Create an Account");
    private By menIcon = By.id("ui-id-5");
    private By topsIcon = By.linkText("Tops");
    private By jacketsIcon = By.linkText("Jackets");
    private By searchField = By.id("search");
    private By noOfItems = By.id("toolbar-amount");
    private By noResultsFound = By.cssSelector(".message.notice");


    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public void clickSignupButton(){
        driver.findElement(signUpButton).click();
    }


    public void NavigateToJackets(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(menIcon)).perform();

        action.moveToElement(driver.findElement(topsIcon)).perform();

        driver.findElement(jacketsIcon).click();
    }


    public void searchForItem(String item){
        driver.findElement(searchField).sendKeys(item);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    public String getNoOfItems(){
        return driver.findElement(noOfItems).getText();
    }

    public String getNoResultsMessage(){
        return driver.findElement(noResultsFound).getText();
    }

}
