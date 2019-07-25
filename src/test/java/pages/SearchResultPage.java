package pages;

/**
 * This class is created to define page objects of Search Result Page in VakantieDiscounter application
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

import java.util.List;

import static util.BaseUtil.Wait;
import static util.BaseUtil.clickOn;

public class SearchResultPage {
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

    @FindBy(how = How.XPATH, using = "//span[@class='options-list__label-text'][contains(text(),'Amsterdam (Schiphol)')]")
    private WebElement linkFlyFromAmsterdam;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'All inclusive')]")
    private WebElement linkBoardTypeAllInclusive;

    @FindBy(how = How.ID, using = "search-results-list")
    private WebElement panelSearchResults;

    @FindBy(how = How.XPATH, using = "//div[@id='email-subscription-popup']//button[contains(text(),'close')]")
    private WebElement btnClosePopup;

    /**
     * filterSearchResults method will apply filters on search results:
     * 1. select Include Flight
     * 2. select fly from Amsterdam
     * 3. Select board type as All Inclusive
     */

    public void filterSearchResults() {
        clickOn(linkIncludeFlight);
        Wait(1);
        clickOn(linkFlyFromAmsterdam);
        Wait(1);
        clickOn(linkBoardTypeAllInclusive);
        Wait(1);
    }

    /**
     * selectPackageByIndex method will select package at specific index on filtered search results
     */
    public void selectPackageByIndex(int packageIndex) {
        try {
            clickOn(btnClosePopup);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<WebElement> allPackages = panelSearchResults.findElements(By.xpath("//li[starts-with(@id, 'search-results')]"));
        allPackages.get(packageIndex).findElement(By.xpath("//li[starts-with(@id, 'search-results')]//span[contains(text(),'Bekijk')]")).click();
    }
}
