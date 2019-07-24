package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static util.BaseUtil.clickOn;
import static util.DriverSetup.driver;


/**
 * This class is created to define page objects of HomePage page in Caspar application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */

public class HomePage {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@href=\"/zonvakantie\"]/h3")
    private WebElement linkSunVertical;


    @FindBy(how = How.XPATH, using = "//div[@id=\"cookiebar\"]/div/div/div/div[2]/a")
    private WebElement btnAllowCookies;


    /**
     * addPatient method will -
     * 1. Open add patient module from dashboard
     * 2. Enter default mandatory details of patient, unless other details not entered from Feature file/set in default properties file
     * 3. Clicks on save button
     */
    public void navigateToSunVertical() {
        allowCookies();
        clickOn(linkSunVertical);
    }

    /**
     * getCredentials method will be called after adding patient and this will-
     * 1. capture credentials of newly created patients and update into hashmap
     * 2. Close the dialog box
     */
    public void allowCookies() {
        clickOn(btnAllowCookies);
    }
}
