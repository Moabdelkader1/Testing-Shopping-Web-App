package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JacketPage {
    private WebDriver driver;
    private By sizeButton = By.id("option-label-size-143-item-168");
    private By colorButton = By.id("option-label-color-93-item-49");
    private By purchaseButton = By.id("product-addtocart-button");
    private By shoppingCartButton = By.linkText("shopping cart");

    public JacketPage(WebDriver driver){
        this.driver=driver;
    }

    public void purchaseJacket(){

        driver.findElement(sizeButton).click();
        driver.findElement(colorButton).click();

        driver.findElement(purchaseButton).click();

        // Explicit wait for the shopping cart button to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartButton));

        driver.findElement(shoppingCartButton).click();

    }
}
