package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderSuccessPage {
    private WebDriver driver;

    private By confMessage =By.xpath("//*[@id='maincontent']/div[1]/h1/span");

    public OrderSuccessPage(WebDriver driver){
        this.driver=driver;
    }

    public String successMessage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confMessage));

        // Return the text of the confirmation message
        return driver.findElement(confMessage).getText();
    }

}
