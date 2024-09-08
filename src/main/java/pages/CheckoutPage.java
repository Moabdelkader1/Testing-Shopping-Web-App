package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomStr;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private RandomStr randomStr;

    private By companyName = By.cssSelector("[name='company']");
    private By address = By.cssSelector("[name='street[0]']");
    private By city = By.cssSelector("[name='city']");
    private By postalCode = By.cssSelector("[name='postcode']");
    private By country = By.cssSelector("[name='country_id']");
    private By phoneNumber = By.cssSelector("[name='telephone']");
    private By shippingMethodRadio = By.xpath("//*[@id='checkout-shipping-method-load']/table/tbody/tr[1]/td[1]/input");
    private By nextButton = By.xpath("//button[@class='button action continue primary']");
    private By totalPrice = By.xpath("//*[@id='opc-sidebar']//tr[3]/td");
    private By placeOrderButton = By.xpath("//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button");


    public CheckoutPage(WebDriver driver){
        this.driver=driver;
        this.randomStr = new RandomStr();
    }

    public void fillShippingData() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyName));

        driver.findElement(companyName).sendKeys(randomStr.randomize(6, true, false));
        driver.findElement(address).sendKeys(randomStr.randomize(8, true, false));
        driver.findElement(city).sendKeys(randomStr.randomize(8, true, false));
        driver.findElement(postalCode).sendKeys(randomStr.randomize(5, false, true));
        driver.findElement(phoneNumber).sendKeys(randomStr.randomize(11, false, true));


        Select countrySelect = new Select(driver.findElement(country));
        countrySelect.selectByVisibleText("Egypt");

        driver.findElement(shippingMethodRadio).click();

        wait.until(ExpectedConditions.elementToBeSelected(shippingMethodRadio));
        driver.findElement(nextButton).click();


    }

    public void reviewPayment() throws InterruptedException {

        // Retry clicking the place order button in case of interception
        for (int i = 0; i < 3; i++) {
            try {
                driver.findElement(placeOrderButton).click();
                break;
            } catch (ElementNotInteractableException e) {
                Thread.sleep(3000);
            }

        }

    }

    public String getTotalPrice() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        return driver.findElement(totalPrice).getText();

    }


}
