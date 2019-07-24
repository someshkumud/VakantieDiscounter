package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil.*;

import static util.BaseUtil.Wait;
import static util.BaseUtil.clickOn;


/**
 * This class is created to define page objects of HomePage page in Caspar application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */

public class OfferDetailsPage {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public OfferDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'controleer prijs')]")
    private WebElement btnCheckPrice;


    @FindBy(how = How.XPATH, using = "//button[@id=\"offer-receipt-bookbutton\"]")
    private WebElement btnBookNow;


    /**
     * addPatient method will -
     * 1. Open add patient module from dashboard
     * 2. Enter default mandatory details of patient, unless other details not entered from Feature file/set in default properties file
     * 3. Clicks on save button
     */
    public void checkPrice() {
        clickOn(btnCheckPrice);
        Wait(4);
        clickOn(btnBookNow);
    }

}
