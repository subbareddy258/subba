package stepDefinitions;

import Pages.HomePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class HomePageStepDefinition {
        private WebDriver driver;
    private HomePages HomePage;
    private static Logger logger = LogManager.getLogger(HomePageStepDefinition.class);


    @Given("I am on the Urban Ladder home page")
        public void navigateToHomePage() {
        logger.info("user in home page");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.urbanladder.com/");
        HomePage = new HomePages(driver);
        }

        @When("I search for {string}")
        public void searchForProduct(String product) {
            logger.info("userClicked on search page");
            HomePage.searchField(product);
            HomePage.searchButton();
        }

        @Then("I should see search results related to {string}")
        public void verifySearchResults(String expectedQuery) {
            String pageTitle = driver.getCurrentUrl();
            Assert.assertTrue(pageTitle.contains(expectedQuery),"Search results do not match the expected query");
            driver.quit();
        }
    }
