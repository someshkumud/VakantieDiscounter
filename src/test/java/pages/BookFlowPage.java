package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static util.BaseUtil.*;
import static util.DriverSetup.driver;


/**
 * This class is created to define page objects of Book Flow Page in VakantieDiscounter application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */

public class BookFlowPage {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public BookFlowPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@name=\"passenger-01_name-salutation\"]/parent::*")
    private List<WebElement> radioPassenger1Salutation;


    @FindBy(how = How.XPATH, using = "//input[@name=\"passenger-02_name-salutation\"]/parent::*")
    private List<WebElement> radioPassenger2Salutation;

    @FindBy(how = How.NAME, using = "passenger-01_name-first")
    private WebElement txtPassenger1FirstName;

    @FindBy(how = How.NAME, using = "passenger-01_name-last")
    private WebElement txtPassenger1LastName;

    @FindBy(how = How.NAME, using = "passenger-01_name-birthdate-1")
    private WebElement selectPassenger1DOBdd;

    @FindBy(how = How.NAME, using = "passenger-01_name-birthdate-2")
    private WebElement selectPassenger1DOBmm;

    @FindBy(how = How.NAME, using = "passenger-01_name-birthdate-3")
    private WebElement selectPassenger1DOByy;

    @FindBy(how = How.XPATH, using = "//fieldset[@class=\"passenger-01\"]//a[contains(text(),'wijzigen')]")
    private WebElement linkPassenger1EditNationality;

    @FindBy(how = How.XPATH, using = "//button[@id=\"menu-toggle-1\"]")
    private WebElement selectPassenger1Nationality;

    @FindBy(how = How.NAME, using = "passenger-02_name-first")
    private WebElement txtPassenger2FirstName;

    @FindBy(how = How.NAME, using = "passenger-02_name-last")
    private WebElement txtPassenger2LastName;

    @FindBy(how = How.NAME, using = "passenger-02_name-birthdate-1")
    private WebElement selectPassenger2DOBdd;

    @FindBy(how = How.NAME, using = "passenger-02_name-birthdate-2")
    private WebElement selectPassenger2DOBmm;

    @FindBy(how = How.NAME, using = "passenger-02_name-birthdate-3")
    private WebElement selectPassenger2DOByy;

    @FindBy(how = How.XPATH, using = "//fieldset[@class=\"passenger-02\"]//a[contains(text(),'wijzigen')]")
    private WebElement linkPassenger2EditNationality;

    @FindBy(how = How.XPATH, using = "//button[@id=\"menu-toggle-1\"]")
    private WebElement selectPassenger2Nationality;

    @FindBy(how = How.ID, using = "menu-toggle-:countrycode")
    private WebElement selectMainApplicantCountry;

    @FindBy(how = How.NAME, using = "passenger-01_address-postcode")
    private WebElement txtMainApplicantPostCode;

    @FindBy(how = How.NAME, using = "passenger-01_address-number")
    private WebElement txtMainApplicantHouseNumber;

    @FindBy(how = How.NAME, using = "passenger-01_address-addition")
    private WebElement txtMainApplicantAddition;

    @FindBy(how = How.NAME, using = "passenger-01_email")
    private WebElement txtMainApplicantEmail;

    @FindBy(how = How.NAME, using = "passenger-01_telephone-primary")
    private WebElement txtMainApplicantPhoneNumber;

    @FindBy(how = How.NAME, using = "stay-home_name")
    private WebElement txtEmergencyContactName;

    @FindBy(how = How.NAME, using = "stay-home_email")
    private WebElement txtEmergencyContactEmail;

    @FindBy(how = How.NAME, using = "stay-home_tel")
    private WebElement txtEmergencyContactPhoneNumber;

    @FindBy(how = How.XPATH, using = "(//a[@href=\"#booking-questions\" and contains(text(),'Naar stap 2: Aanvullende opties') ])[2]")
    private WebElement btnStep2;


    /**
     * enterTravelerDetails method will -
     * 1. Enter traveler 1 & traveler 2 details on the page
     * 2. Enter contact and emergency contact details on the page
     * 3. Clicks on "Naar stap 2: Aanvullende opties" button
     */
    public void enterTravelerDetails() {
        enterTraveler1Details();
        enterTraveler2Details();
        enterContactDetails();
        enterEmergencyContactDetails();
        clickOn(btnStep2);
    }


    private void enterEmergencyContactDetails() {
        enterValueInTextBox(txtEmergencyContactName, defaultProperties.get("naam"));
        enterValueInTextBox(txtEmergencyContactPhoneNumber, defaultProperties.get("telefoonNummer"));
    }

    private void enterContactDetails() {
        clickOn(selectMainApplicantCountry);
        Wait(1);
        WebElement elementList = driver.findElement(By.xpath("(//a[contains(text(),'" + defaultProperties.get("land") + "')])[1]"));
        clickOnElementAction(elementList);
        enterValueInTextBox(txtMainApplicantPostCode, defaultProperties.get("postcode"));
        enterValueInTextBox(txtMainApplicantHouseNumber, defaultProperties.get("huisnummer"));
        enterValueInTextBox(txtMainApplicantAddition, defaultProperties.get("straat") + ", " + defaultProperties.get("woonplaats"));
        enterValueInTextBox(txtMainApplicantEmail, defaultProperties.get("emailDdres"));
        enterValueInTextBox(txtMainApplicantPhoneNumber, defaultProperties.get("telefoonNummer"));

    }

    private void enterTraveler1Details() {
        selectRadioButtonValue(radioPassenger1Salutation, defaultProperties.get("aanhef1"));
        enterValueInTextBox(txtPassenger1FirstName, defaultProperties.get("voornaam1"));
        enterValueInTextBox(txtPassenger1LastName, defaultProperties.get("achternaam1"));
        enterDateOfBirthForPassenger1();
        clickOn(linkPassenger1EditNationality);
        Wait(1);
        clickOn(selectPassenger1Nationality);
        Wait(1);
        WebElement elementList = driver.findElement(By.xpath("(//a[contains(text(),'" + defaultProperties.get("nationaliteit1") + "')])[1]"));
        clickOnElementAction(elementList);
    }

    private void enterTraveler2Details() {
        selectRadioButtonValue(radioPassenger2Salutation, defaultProperties.get("aanhef2"));
        enterValueInTextBox(txtPassenger2FirstName, defaultProperties.get("voornaam2"));
        enterValueInTextBox(txtPassenger2LastName, defaultProperties.get("achternaam2"));
        enterDateOfBirthForPassenger2();
        clickOn(linkPassenger2EditNationality);
        Wait(1);
        clickOn(selectPassenger2Nationality);
        Wait(1);
        WebElement elementList = driver.findElement(By.xpath("(//a[contains(text(),'" + defaultProperties.get("nationaliteit2") + "')])[1]"));
        clickOnElementAction(elementList);
    }

    private void enterDateOfBirthForPassenger1() {
        selectDropdownByVisibleText(selectPassenger1DOBdd, defaultProperties.get("geboortedatum1").split(" ")[0].trim());
        selectDropdownByVisibleText(selectPassenger1DOBmm, defaultProperties.get("geboortedatum1").split(" ")[1].trim());
        selectDropdownByVisibleText(selectPassenger1DOByy, defaultProperties.get("geboortedatum1").split(" ")[2].trim());
    }

    private void enterDateOfBirthForPassenger2() {
        selectDropdownByVisibleText(selectPassenger2DOBdd, defaultProperties.get("geboortedatum2").split(" ")[0]);
        selectDropdownByVisibleText(selectPassenger2DOBmm, defaultProperties.get("geboortedatum2").split(" ")[1]);
        selectDropdownByVisibleText(selectPassenger2DOByy, defaultProperties.get("geboortedatum2").split(" ")[2]);
    }
}
