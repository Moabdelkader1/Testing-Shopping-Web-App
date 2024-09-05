package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage {

    private WebDriver driver;
    private WebElement menIcon;
    private WebElement topsIcon;
    private WebElement jacketsIcon;
    private WebElement montanaJacket;
    private WebElement sizeButon;
    private WebElement colorButton;

    private WebElement shoppingCartButton;

    private WebElement purchaseButton;

    public ShoppingPage(WebDriver driver){
        this.driver=driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        menIcon = driver.findElement(By.id("ui-id-5"));
    }

    public void goToJacketsPage(){
        Actions action = new Actions(driver);
        action.moveToElement(menIcon).perform();

        topsIcon = driver.findElement(By.linkText("Tops"));

        action.moveToElement(topsIcon).perform();

        jacketsIcon=driver.findElement(By.linkText("Jackets"));

        jacketsIcon.click();

    }

    public void purchaseJacket(){
        montanaJacket = driver.findElement(By.linkText("Montana Wind Jacket"));
        montanaJacket.click();

        sizeButon=driver.findElement(By.id("option-label-size-143-item-168"));
        sizeButon.click();

        colorButton = driver.findElement(By.id("option-label-color-93-item-49"));
        colorButton.click();

        purchaseButton = driver.findElement(By.id("product-addtocart-button"));

        purchaseButton.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("shopping cart"))));
        shoppingCartButton = driver.findElement(By.linkText("shopping cart"));
        shoppingCartButton.click();

    }


}
