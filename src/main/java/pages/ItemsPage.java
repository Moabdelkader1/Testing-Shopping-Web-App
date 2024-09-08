package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ItemsPage {

    private WebDriver driver;
    private By montanaJacket = By.linkText("Montana Wind Jacket");
    private By cronusYogaPant = By.linkText("Cronus Yoga Pant");
    private By machStreetSweatshirt = By.linkText("Mach Street Sweatshirt");

    public ItemsPage(WebDriver driver){
        this.driver=driver;

    }

    public void goToMontanaJacket(){
        driver.findElement(montanaJacket).click();

    }
    public void goToCronusYogaPant(){
        driver.findElement(cronusYogaPant).click();
    }

    public void goToMachStreetSweatshirt(){
        driver.findElement(machStreetSweatshirt).click();
    }


}
