package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * This class is created to define page objects and methods for Additional Option Page in VakantieDiscounter application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */

public class AdditionalOptionPage {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public AdditionalOptionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@class='btn primary']")
    private List<WebElement> btnStep3;


    /**
     * navigateToStep3 method will -
     * 1. Clicks on "Naar stap 3: Overzicht en betalen" button
     */
    public void navigateToStep3() {
        btnStep3.get(1).sendKeys(Keys.ENTER);
    }
}
