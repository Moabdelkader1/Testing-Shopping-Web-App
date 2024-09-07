package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class JacketsPage {

    private WebDriver driver;
    private By montanaJacket = By.linkText("Montana Wind Jacket");


    public JacketsPage(WebDriver driver){
        this.driver=driver;

    }


    public void goToMontanaJacket(){
        driver.findElement(montanaJacket).click();

    }


}
