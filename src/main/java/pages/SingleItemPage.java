package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SingleItemPage {
    private WebDriver driver;
    private By mediumSizeButton = By.id("option-label-size-143-item-168");
    private By blackColorButton = By.id("option-label-color-93-item-49");
    private By purchaseButton = By.id("product-addtocart-button");
    private By shoppingCartButton = By.linkText("shopping cart");

    public SingleItemPage(WebDriver driver){
        this.driver=driver;
    }

    public void purchaseJacket(){

        driver.findElement(mediumSizeButton).click();
        driver.findElement(blackColorButton).click();
        driver.findElement(purchaseButton).click();

    }

    public void goToShoppingCart(){

        // Explicit wait for the shopping cart button to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartButton));
        driver.findElement(shoppingCartButton).click();
    }
}
