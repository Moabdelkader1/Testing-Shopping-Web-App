package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.RandomStr;


public class SignUpPage {
    private WebDriver driver;
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By email = By.id("email_address");
    private By password = By.id("password");
    private By confirmPassword = By.id("password-confirmation");
    private By createButton = By.id("form-validate");
    private RandomStr random;

    public SignUpPage(WebDriver driver){
        this.driver=driver;

        random=new RandomStr();
    }


    public void enterSignUpDetails(){


        String name = random.randomize(6,true,false);
        String mail = random.randomize(8,true,false) + "@" + random.randomize(3,true,false) +".com";
        String pass = random.randomize(6,true,false) + random.randomize(6,false,true);


        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys(name);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);

        scrollToCreateButton();
        driver.findElement(createButton).submit();

    }

    private void scrollToCreateButton() {
        WebElement button = driver.findElement(createButton);
        Actions actions = new Actions(driver);
        actions.scrollToElement(button).perform();
    }


}
