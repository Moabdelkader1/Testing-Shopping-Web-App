package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {

    private WebDriver driver;
    private RandomStr randomStr;
    private WebElement proceedButton;
    private WebElement companyName;
    private WebElement address;
    private WebElement city;
    private WebElement state;
    private WebElement postalCode;
    private WebElement country;
    private WebElement phoneNumber;
    private WebElement shippingMethodRadio;
    private WebElement nextButton;
    private WebElement placeOrderButton;
    private WebElement totalPrice;





    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        proceedButton=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/ul/li[1]/button"));
    }

    public void proceedToShipping(){
        proceedButton.click();
    }

    public void checkOutData(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        companyName=driver.findElement(By.cssSelector("[name='company']"));
        address=driver.findElement(By.cssSelector("[name='street[0]']"));
        city=driver.findElement(By.cssSelector("[name='city']"));
        postalCode=driver.findElement(By.cssSelector("[name='postcode']"));

        country=driver.findElement(By.cssSelector("[name='country_id']"));
        Select select = new Select(country);
        select.selectByVisibleText("Egypt");

        state=driver.findElement(By.cssSelector("[name='region_id']"));

        phoneNumber=driver.findElement(By.cssSelector("[name='telephone']"));

        shippingMethodRadio=driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input"));

        nextButton=driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button"));

        randomStr=new RandomStr();

        companyName.sendKeys(randomStr.randomize(6,true,false));
        address.sendKeys(randomStr.randomize(8,true,false));
        city.sendKeys(randomStr.randomize(8,true,false));
        postalCode.sendKeys(randomStr.randomize(5,false,true));
       // state.sendKeys(randomStr.randomize(8,true,false));
        phoneNumber.sendKeys(randomStr.randomize(11,false,true));
        shippingMethodRadio.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.linkText("This is a required field."),"This is a required field."));
        nextButton.click();
    }

    public String getTotalPrice(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        totalPrice = driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[3]/td"));
        return totalPrice.getText();
    }

    public void reviewPayment() throws InterruptedException {


        placeOrderButton=driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")));
        for(int i=0;i<3;i++) {
            try {
                placeOrderButton.click();
                break;
            } catch (ElementClickInterceptedException elementClickInterceptedException) {
                Thread.sleep(5);
            }
        }

    }

}
