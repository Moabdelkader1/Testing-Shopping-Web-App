package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShoppingCartPage {

    private WebDriver driver;
    private By proceedButton = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/ul/li[1]/button");


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;

    }
    public void proceedToShipping() {
        driver.findElement(proceedButton).click();
    }


}