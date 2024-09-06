package stepDefinitions;
import pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class StepDefinitions {

    private WebDriver driver;

    private ShoppingCartPage shoppingCartPage;

    private SearchingMainPage searchingMainPage;

    private CheckoutPage checkoutPage;


    @Given("the user is registered")
    public void the_user_is_registered() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://magento.softwaretestingboard.com/");

        HomePage homePage = new HomePage(driver);


        homePage.clickSignupButton();

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterSignUpDetails();


    }


    @And("the user has added a men's jacket to the cart")
    public void theUserAddsAJacketToTheCart() {

        ShoppingPage shoppingPage = new ShoppingPage(driver);

        shoppingPage.NavigateToJackets();

        shoppingPage.goToMontanaJacket();

        JacketPage jacketPage =new JacketPage(driver);
        jacketPage.purchaseJacket();

    }

    @When("the user proceeds to checkout")
    public void theUserCheckoutJacketFromTheCart()  {
        shoppingCartPage =new ShoppingCartPage(driver);

        shoppingCartPage.proceedToShipping();

        checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillShippingData();


    }

    @Then("the total price should be displayed")
    public void the_purchase_is_completed_and_total_price_should_appear() throws InterruptedException {
        assertEquals(checkoutPage.getTotalPrice(),"$54.00");
        checkoutPage.reviewPayment();
    }



    @And("the user should receive a confirmation")
    public void the_user_receives_a_confirmation(){


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/checkout/onepage/success/"));

        OrderSuccessPage orderSuccessPage = new OrderSuccessPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/checkout/onepage/success/","1st assertion");
        softAssert.assertEquals(orderSuccessPage.successMessage(),"Thank you for your purchase!","2nd assertion");

        softAssert.assertAll();

        driver.quit();
    }



    @When("the user searches for \"shirt\"")
    public void theUserSearchesFor() {

        searchingMainPage=new SearchingMainPage(driver);
        searchingMainPage.searchForItem("shirt");
    }

    @Then("five related results should be displayed")
    public void fiveRelatedResultsShouldBeShown() {
        assertEquals(searchingMainPage.getNoOfItems(),"5 Items");
        driver.quit();
    }





}
