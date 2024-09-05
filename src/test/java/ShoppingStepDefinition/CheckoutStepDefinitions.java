package ShoppingStepDefinition;
import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class CheckoutStepDefinitions {

    private WebDriver driver;
    private HomePage homePage;

    private SignUpPage signUpPage;
    private ShoppingPage shoppingPage;
    private ShoppingCartPage shoppingCartPage;
    private OrderSuccessPage orderSuccessPage;

    @Given("the user is registered")
    public void the_user_is_registered() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://magento.softwaretestingboard.com/");

        homePage = new HomePage(driver);

        //System.out.println(driver.getCurrentUrl());

        homePage.clickSignupButton();

        signUpPage = new SignUpPage(driver);

        signUpPage.fillData();


    }

    public WebDriver getDriver(){
        return driver;
    }

    @And("the user adds a jacket to the cart")
    public void theUserAddsAJacketToTheCart() {

        shoppingPage = new ShoppingPage(driver);

        shoppingPage.goToJacketsPage();

        assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");

        shoppingPage.purchaseJacket();
    }

    @When("the user checkout jacket from the cart")
    public void theUserCheckoutJacketFromTheCart()  {
        shoppingCartPage =new ShoppingCartPage(driver);

        shoppingCartPage.proceedToShipping();
        shoppingCartPage.checkOutData();


    }

    @Then("The purchase is completed and total price should appear")
    public void the_purchase_is_completed_and_total_price_should_appear() throws InterruptedException {
        assertEquals(shoppingCartPage.getTotalPrice(),"$54.00");
        shoppingCartPage.reviewPayment();
    }

    @And("the user receives a confirmation")
    public void the_user_receives_a_confirmation(){


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/checkout/onepage/success/"));

        orderSuccessPage = new OrderSuccessPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/checkout/onepage/success/","1st assertion");
        softAssert.assertEquals(orderSuccessPage.successMessage(),"Thank you for your purchase!","2nd assertion");

        softAssert.assertAll();
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }



}
