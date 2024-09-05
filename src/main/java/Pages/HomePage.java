package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private final WebElement signUpButton;
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        signUpButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
    }

    public void clickSignupButton(){
        signUpButton.click();
    }

}
