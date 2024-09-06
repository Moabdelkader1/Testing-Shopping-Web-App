package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By signUpButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void clickSignupButton(){
        driver.findElement(signUpButton).click();
    }

}
