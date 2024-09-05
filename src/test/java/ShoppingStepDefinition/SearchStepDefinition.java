package ShoppingStepDefinition;

import Pages.HomePage;
import Pages.SearchingMainPage;
import Pages.ShoppingPage;
import Pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class SearchStepDefinition {

    private WebDriver driver;
    private HomePage homePage;

    private SignUpPage signUpPage;

    private SearchingMainPage searchingMainPage;
    private CheckoutStepDefinitions checkoutStepDefinitions;

    @Given("the user registered")
    public void theUserRegistered() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://magento.softwaretestingboard.com/");

        homePage = new HomePage(driver);

        //System.out.println(driver.getCurrentUrl());

        homePage.clickSignupButton();

        signUpPage = new SignUpPage(driver);

        signUpPage.fillData();

    }

    @When("the user searches for shirt")
    public void theUserSearchesFor() {

        searchingMainPage=new SearchingMainPage(driver);
        searchingMainPage.searchForItem("shirt");
    }

    @Then("five related results should be shown")
    public void fiveRelatedResultsShouldBeShown() {
        assertEquals(searchingMainPage.getNoOfItems(),"5 Items");
        driver.quit();
    }



}
