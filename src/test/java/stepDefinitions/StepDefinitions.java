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

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private ShoppingCartPage shoppingCartPage;
    private ItemsPage itemsPage;
    private SingleItemPage singleItemPage;
    private CheckoutPage checkoutPage;
    private OrderSuccessPage orderSuccessPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");

        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        itemsPage = new ItemsPage(driver);
        singleItemPage =new SingleItemPage(driver);
        shoppingCartPage =new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderSuccessPage = new OrderSuccessPage(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("the user is registered")
    public void the_user_is_registered() {

        homePage.clickSignupButton();

        signUpPage.enterSignUpDetails();
    }


    @And("the user has added a men's jacket to the cart")
    public void theUserAddsAJacketToTheCart() {

        homePage.NavigateToJackets();
        itemsPage.goToMontanaJacket();
        singleItemPage.purchaseJacket();

    }

    @When("the user proceeds to checkout")
    public void theUserCheckoutJacketFromTheCart() throws InterruptedException {

        singleItemPage.goToShoppingCart();

        shoppingCartPage.proceedToShipping();

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

    @Then("a message should indicate that no items were found")
    public void aMessageShouldIndicateThatNoItemsWereFound() {
        assertEquals(homePage.getNoResultsMessage(),"Your search returned no results.");
    }

    @Given("the user has added a men's pants to the cart")
    public void theUserHasAddedAMenSPantsToTheCart() {
        homePage.NavigateToPants();

        itemsPage.goToCronusYogaPant();

        singleItemPage.purchasePants();
    }

    @And("the user has added a t-shirt to the cart")
    public void theUserHasAddedATShirtToTheCart() {
        homePage.NavigateToTshirts();

        itemsPage.goToMachStreetSweatshirt();

        singleItemPage.purchaseTshirt();

    }

    @Then("the total price should be displayed for both items")
    public void theTotalPriceShouldBeDisplayedForBothItems() throws InterruptedException {
        assertEquals(checkoutPage.getTotalPrice(),"$110.40");
        checkoutPage.reviewPayment();
    }

}
