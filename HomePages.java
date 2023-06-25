package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePages {
    private WebDriver driver;
    private By searchField = By.id("search");
    private By searchButton = By.id("search_button");
    private By repeatedPassword = By.name("repeatedPassword");

    public HomePages(WebDriver driver) {
        this.driver = driver;

    }

    public void searchField(String query)
    {
        driver.findElement(searchField).sendKeys(query);
    }
    public void searchButton()
    {
        driver.findElement(searchButton).click();
    }


}
