package pages;

/**
 * This class is created to define page objects of Login page in Caspar application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 06/06/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;

import java.util.List;

public class SearchResultPage extends BaseUtil {
    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Incl. vlucht')]")
    private WebElement linkIncludeFlight;


    @FindBy(how = How.XPATH, using = "//span[@class=\"options-list__label-text\"][contains(text(),'Amsterdam (Schiphol)')]")
    private WebElement linkFlyFromAmsterdam;


    @FindBy(how = How.XPATH, using = "//span[contains(text(),'All inclusive')]")
    private WebElement linkBoardTypeAllInclusive;

    @FindBy(how = How.ID, using = "search-results-list")   //----//button[@class='transport-arranged']
    private WebElement panelSearchResults;


    @FindBy(how = How.XPATH, using = "//div[@id=\"email-subscription-popup\"]//button[contains(text(),'close')]")
    private WebElement btnClosePopup;

    /**
     * loginToCasper method will be called after navigating to Caspar application and it will-
     * 1. Enter login credentials on login page and click on login button
     */

    public void filterSearchResults() {
        clickOn(linkIncludeFlight);
        Wait(1);
        clickOn(linkFlyFromAmsterdam);
        Wait(1);
        clickOn(linkBoardTypeAllInclusive);
        Wait(1);
    }

    public void selectPackageByIndex(int packageIndex) {
        try {
            clickOn(btnClosePopup);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Wait(1);
        List<WebElement> allPackages = panelSearchResults.findElements(By.xpath("//li[starts-with(@id, 'search-results')]"));
        allPackages.get(packageIndex).findElement(By.xpath("//li[starts-with(@id, 'search-results')]//span[contains(text(),'Bekijk')]")).click();
        Wait(2);
    }
}
