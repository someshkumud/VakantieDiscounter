package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static util.BaseUtil.clickOn;
import static util.DriverSetup.driver;


/**
 * This class is created to define page objects of HomePage page in VakantieDiscounter application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */

public class ConfirmationPage {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public ConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//span[@class=\"checkbox-option\"]")
    private List<WebElement> checkBoxGroup;


    @FindBy(how = How.XPATH, using = "//a[@class='btn btn--theme--primary btn--large']")
    private WebElement btnConfirm;


    /**
     * confirmDetails method will -
     * 1. click on all checkboxes on the confirmation screen
     * 2. Clicks on confirm button
     */
    public void confirmDetails() {
        if (checkBoxGroup.size() != 0) {
            for (WebElement checkBox : checkBoxGroup) {
                clickOn(checkBox);
            }
            clickOn(btnConfirm);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(btnConfirm));
        }
    }
//        Wait(5);
}

