package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ItemsPage {

    private WebDriver driver;
    private By montanaJacket = By.linkText("Montana Wind Jacket");

    public ItemsPage(WebDriver driver){
        this.driver=driver;
    }

    public void goToMontanaJacket(){
        driver.findElement(montanaJacket).click();
    }
}
