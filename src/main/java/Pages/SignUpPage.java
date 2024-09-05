package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;
    private WebElement fname;
    private WebElement lname;
    private WebElement email;
    private WebElement password;
    private WebElement confPassword;
    private WebElement createButton;
    private RandomStr random;

    public SignUpPage(WebDriver driver){
        this.driver=driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        fname = driver.findElement(By.id("firstname"));
        lname = driver.findElement(By.id("lastname"));
        email = driver.findElement(By.id("email_address"));
        password = driver.findElement(By.id("password"));
        confPassword = driver.findElement(By.id("password-confirmation"));
        createButton = driver.findElement(By.id("form-validate"));

    }


//    public String randomize(int len,Boolean useLetters,Boolean useNumbers){
//        return RandomStringUtils.random(len, useLetters, useNumbers);
//
//    }


    public void fillData(){

        random=new RandomStr();


        String fn = random.randomize(6,true,false);
       // String ln = randomize(6,true,false);
        String mail = random.randomize(8,true,false) + "@" + random.randomize(3,true,false) +".com";
        String pass = random.randomize(6,true,false) + random.randomize(6,false,true);


        fname.sendKeys(fn);
        lname.sendKeys(fn);
        email.sendKeys(mail);
        password.sendKeys(pass);
        confPassword.sendKeys(pass);

        Actions actions = new Actions(driver);
        actions.scrollToElement(createButton).perform();

        createButton.submit();
    }


}
