package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomStr;

import java.time.Duration;

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