package pages;
/**
 * This class is created to define page objects of Consent page in Caspar application
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

import static util.DriverSetup.driver;

public class SunVerticalPage extends BaseUtil {

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

    @FindBy(how = How.XPATH, using = "//div[@id=\"search-box\"]/div/button")
    private WebElement btnSearchHoliday;

    @FindBy(how = How.ID, using = "adults.0")
    private WebElement selectAdults;

    @FindBy(how = How.ID, using = "children.0")
    private WebElement selectChildrens;

    @FindBy(how = How.ID, using = "babies.0")
    private WebElement selectBabies;


    /**
     * verifyVisibilityOfMedicalInformationPageAndClosePage method will -
     * 1. verify Visibility Of Medical Information Page And Close Page
     * 2. Close Page
     */
    public void searchHoliday() {
//        selectDestination(defaultProperties.get("destination"));
        selectDropdownByVisibleText(selectDestination, driver.findElement(By.xpath("//div[@id=\"search-box\"]//ul[3]//a[contains(text(),'" + defaultProperties.get("destination") + "')]")));
        selectDateInCalander(selectTravelDate, defaultProperties.get("travelDate"));
//        selectDropdownByVisibleText(selectTravelDate, driver.findElement(By.xpath("//div[@id=\"search-box\"]//input[@value='" + defaultProperties.get("travelDate") + "')]")));
        selectDropdownByVisibleText(selectDuration, driver.findElement(By.xpath("//label[contains(text(), '"+defaultProperties.get("duration")+"')]")));

        selectTravelers();
        clickOn(btnSearchHoliday);
    }


    private void selectTravelers() {
        clickOn(selectTravelParty);
        selectDropdownByValue(selectAdults, defaultProperties.get("adultTravelers"));
        selectDropdownByValue(selectChildrens, defaultProperties.get("childerenTravelers"));
        selectDropdownByValue(selectBabies, defaultProperties.get("babyTravelers"));
        clickOn(selectTravelParty);
    }


}
