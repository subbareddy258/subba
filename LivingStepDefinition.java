package stepDefinitions;

import Pages.LivingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LivingStepDefinition {
    private WebDriver driver;
    private LivingPage LivingPages;
    private static Logger logger = LogManager.getLogger(LivingStepDefinition.class);

    @Given("I am on the Urban Ladder search page")
    public void navigateSearchPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.urbanladder.com/");
        LivingPages = new LivingPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("user in home page");
    }

    @When("I select PrayerUnits from living products")
    public void livingProducts() {
        LivingPages.livingProductsMainMenu();
        logger.info("user selected MainMenu");
        LivingPages.livingProductsSubMenu();
        logger.info("user selected submenu");
          }


    @Then("I Get All prices and found max and min price")
    public void iGetAllPricesAndFoundMaxAndMinPrice() throws InterruptedException {
        LivingPages.popUps();
        logger.info("user closed popup");
        LivingPages.price();
        logger.info("user got all prices");
    }

    @Then("find all prices in low to high range")
    public void iGetAllPricesAndFindAllPricesInLowToHighRange() throws InterruptedException {
     LivingPages.popUps();
        LivingPages.sortPrices();
        logger.info("user sorted all prices");
        LivingPages.price();
        driver.quit();
    }
}
