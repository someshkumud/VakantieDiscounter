package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static util.BaseUtil.clickOn;


/**
 * This class is created to define page objects of HomePage page in VakantieDiscounter application
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
     * navigateToSunVertical method will -
     * 1. Allow Cookies and close the pop up
     * 2. Clicks on Sun Vertical view details link
     */
    public void navigateToSunVertical() {
        allowCookies();
        clickOn(linkSunVertical);
    }

    public void allowCookies() {
        clickOn(btnAllowCookies);
    }
}
