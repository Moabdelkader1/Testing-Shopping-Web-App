package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private MontanaJacketPage montanaJacketPage;
    private CheckoutPage checkoutPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");

        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("the user is registered")
    public void the_user_is_registered() {

        homePage.clickSignupButton();

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterSignUpDetails();
    }


    @And("the user has added a men's jacket to the cart")
    public void theUserAddsAJacketToTheCart() {

        homePage.NavigateToJackets();

        JacketsPage jacketsPage = new JacketsPage(driver);
        jacketsPage.goToMontanaJacket();

        montanaJacketPage =new MontanaJacketPage(driver);
        montanaJacketPage.purchaseJacket();

    }

    @When("the user proceeds to checkout")
    public void theUserCheckoutJacketFromTheCart()  {

        montanaJacketPage.goToShoppingCart();

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

        assertEquals(orderSuccessPage.successMessage(),"Thank you for your purchase!");

    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String item) {
        homePage.searchForItem(item);
    }

    @Then("five related results should be displayed")
    public void fiveRelatedResultsShouldBeShown() {
        assertEquals(homePage.getNoOfItems(),"5 Items");
    }

}
