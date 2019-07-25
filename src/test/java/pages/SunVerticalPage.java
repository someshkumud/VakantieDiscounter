package pages;
/**
 * This class is created to define page objects and methods of Sun Vertical Page in VakantieDiscounter application
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

import static util.BaseUtil.*;
import static util.DriverSetup.driver;

public class SunVerticalPage {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public SunVerticalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "select-destination")
    private WebElement selectDestination;

    @FindBy(how = How.ID, using = "select-departure")
    private WebElement selectTravelDate;

    @FindBy(how = How.ID, using = "select-duration")
    private WebElement selectDuration;

    @FindBy(how = How.ID, using = "select-party")
    private WebElement selectTravelParty;

    @FindBy(how = How.XPATH, using = "//div[@id='search-box']/div/button")
    private WebElement btnSearchHoliday;

    @FindBy(how = How.ID, using = "adults.0")
    private WebElement selectAdults;

    @FindBy(how = How.ID, using = "children.0")
    private WebElement selectChildrens;

    @FindBy(how = How.ID, using = "babies.0")
    private WebElement selectBabies;


    /**
     * searchHoliday method will enter the search criteria and search for holiday
     */
    public void searchHoliday() {
        selectDropdownByVisibleText(selectDestination, driver.findElements(By.xpath("//a[contains(text(),'" + defaultProperties.get("destination") + "')]")).get(0));
        selectDateInCalender(selectTravelDate, defaultProperties.get("travelDate"));
        selectDropdownByVisibleText(selectDuration, driver.findElement(By.xpath("//label[contains(text(), '" + defaultProperties.get("duration") + "')]")));

        selectTravelers();
        clickOn(btnSearchHoliday);
    }


    /**
     * selectTravelers method : As travel party could be adult, childrens or babies.
     * This method will select all travel parties in dropdown
     */
    private void selectTravelers() {
        clickOn(selectTravelParty);
        selectDropdownByValue(selectAdults, defaultProperties.get("adultTravelers"));
        selectDropdownByValue(selectChildrens, defaultProperties.get("childerenTravelers"));
        selectDropdownByValue(selectBabies, defaultProperties.get("babyTravelers"));
        clickOn(selectTravelParty);
    }


}
