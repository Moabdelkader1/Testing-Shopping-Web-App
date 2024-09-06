package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage {

    private WebDriver driver;
    private By menIcon = By.id("ui-id-5");
    private By topsIcon = By.linkText("Tops");
    private By jacketsIcon = By.linkText("Jackets");
    private By montanaJacket = By.linkText("Montana Wind Jacket");


    public ShoppingPage(WebDriver driver){
        this.driver=driver;

    }

    public void NavigateToJackets(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(menIcon)).perform();

        action.moveToElement(driver.findElement(topsIcon)).perform();

        driver.findElement(jacketsIcon).click();

    }

    public void goToMontanaJacket(){
        driver.findElement(montanaJacket).click();

    }


}
