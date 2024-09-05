package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderSuccessPage {
    private WebDriver driver;
    private WebElement confMessage;

    public OrderSuccessPage(WebDriver driver){
        this.driver=driver;
    }

    public String successMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"))));

        confMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));

        return confMessage.getText();
    }

}
