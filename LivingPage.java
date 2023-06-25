package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LivingPage {
    private WebDriver driver;
    private By livingFromMainMenu = By.xpath("//div[@id='topnav_wrapper']/ul/li");
    private By livingProductsFromSubMenu = By.xpath("//li[@class='sublist_item']");
    private By popUp = By.xpath("//*[@id='authentication_popup']/div[1]/div/div[2]/a[1]");
    private By prices = By.xpath("//div[@class='price-number']/span");
    private By sortOptions = By.xpath("//div[@class='item']");
    private By priceAsecendingOrder = By.xpath("//li[@data-key='price_asc']");
    List<Double> pricesInList;

    public LivingPage(WebDriver driver) {

        this.driver = driver;

    }

    public void livingProductsMainMenu() {
        List<WebElement> liElements = driver.findElements(livingFromMainMenu);
        System.out.println(liElements.size());
        for (WebElement link : liElements) {
            String linkText = link.getText();
            if (linkText.contains("Living")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(link).perform();
                break;
            }
        }
    }

    public void livingProductsSubMenu() {
        List<WebElement> submenuOptions = driver.findElements(livingProductsFromSubMenu);
        System.out.println(submenuOptions.size());
        for (WebElement submenuOption : submenuOptions) {
            String submenuText = submenuOption.getText();
            System.out.println("submenu" + submenuText);
            if (submenuText.contains("Prayer Units")) {
                submenuOption.click();
                break;
            }
        }

    }

    public void popUps() {
        driver.findElement(popUp).click();

    }

    public void price() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> price = driver.findElements(prices);
        System.out.println("price" + price.size());
        pricesInList = new ArrayList<>();
        for (WebElement prices : price) {
            Thread.sleep(5000);
            String pricesText = prices.getText().replace("₹", "").replace(",", "");
            System.out.println("pricesText" + pricesText);
            pricesInList.add(Double.valueOf(pricesText));
        }
        double maxPrice = Collections.max(pricesInList);
        System.out.println(maxPrice);
        double minPrice = Collections.min(pricesInList);
        System.out.println(minPrice);
        Collections.sort(pricesInList);
        for (double prices : pricesInList) {
            System.out.println(prices);
        }
    }

    public void sortPrices() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(sortOptions).click();
        driver.findElement(priceAsecendingOrder).click();
        System.out.println("prices sorted successfully");
    }

}
