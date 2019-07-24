package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static util.BaseUtil.*;
import static util.DriverSetup.driver;

//import static util.BaseUtil.defaultProperties;


/**
 * This class is created to define page objects of HomePage page in Caspar application
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
     * addPatient method will -
     * 1. Open add patient module from dashboard
     * 2. Enter default mandatory details of patient, unless other details not entered from Feature file/set in default properties file
     * 3. Clicks on save button
     */
    public void enterTravelerDetails() {
        enterTraveler1Details();
        enterTraveler2Details();
        enterContactDetails();
        enterEmergencyContactDetails();

    }

    private void enterEmergencyContactDetails() {
        enterValueInTextBox(txtEmergencyContactName, defaultProperties.get("Naam"));
//        enterValueInTextBox(txtEmergencyContactEmail, defaultProperties.get("Huisnummer"));
        enterValueInTextBox(txtEmergencyContactPhoneNumber, defaultProperties.get("Telefoonnummer"));
        clickOn(btnStep2);
    }

    private void enterContactDetails() {
//        selectDropdownByVisibleText(selectMainApplicantCountry, driver.findElement(By.xpath("(//a[contains(text(),'" + defaultProperties.get("Land") + "')])[1]")));
        enterValueInTextBox(txtMainApplicantPostCode, defaultProperties.get("Postcode"));
        enterValueInTextBox(txtMainApplicantHouseNumber, defaultProperties.get("Huisnummer"));
        enterValueInTextBox(txtMainApplicantAddition, defaultProperties.get("Straat")+", "+defaultProperties.get("Woonplaats"));
        enterValueInTextBox(txtMainApplicantEmail, defaultProperties.get("Emailadres"));
        enterValueInTextBox(txtMainApplicantPhoneNumber, defaultProperties.get("Telefoonnummer"));

    }

    private void enterTraveler1Details() {
//        JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
//        jsExecuter.executeScript("window.scrollBy(0,600)","");
        selectRadioButtonValue(radioPassenger1Salutation, defaultProperties.get("Aanhef1"));
        enterValueInTextBox(txtPassenger1FirstName, defaultProperties.get("Voornaam1"));
        enterValueInTextBox(txtPassenger1LastName, defaultProperties.get("Achternaam1"));
        enterDateOfBirthForPassenger1();
//        clickOn(linkPassenger1EditNationality);
//        Wait(1);
//        selectDropdownByVisibleText(selectPassenger1Nationality, driver.findElement(By.xpath("(//a[contains(text(),'" + defaultProperties.get("Nationaliteit1") + "')])[1]/parent::*")));
//        selectDropdownByVisibleText(selectPassenger1Nationality, driver.findElement(By.xpath("//*[@id=\"booking-questions\"]/div[1]/form[1]/fieldset/div[2]/div/div/div/ul/li[1]/a")));
    }

    private void enterTraveler2Details() {
        selectRadioButtonValue(radioPassenger2Salutation, defaultProperties.get("Aanhef2"));
        enterValueInTextBox(txtPassenger2FirstName, defaultProperties.get("Voornaam2"));
        enterValueInTextBox(txtPassenger2LastName, defaultProperties.get("Achternaam2"));
        enterDateOfBirthForPassenger2();
//        clickOn(linkPassenger2EditNationality);
//        JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
//        jsExecuter.executeScript("window.scrollBy(0,500)","");
//        Wait(1);
//        selectDropdownByVisibleText(selectPassenger2Nationality, driver.findElement(By.xpath("(//a[contains(text(),'" + defaultProperties.get("Nationaliteit2") + "')])[1]/parent::*")));
    }

    private void enterDateOfBirthForPassenger1() {
        selectDropdownByVisibleText(selectPassenger1DOBdd, defaultProperties.get("Geboortedatum1").split(" ")[0].trim());
        selectDropdownByVisibleText(selectPassenger1DOBmm, defaultProperties.get("Geboortedatum1").split(" ")[1].trim());
        selectDropdownByVisibleText(selectPassenger1DOByy, defaultProperties.get("Geboortedatum1").split(" ")[2].trim());
    }

    private void enterDateOfBirthForPassenger2() {
        selectDropdownByVisibleText(selectPassenger2DOBdd, defaultProperties.get("Geboortedatum2").split(" ")[0]);
        selectDropdownByVisibleText(selectPassenger2DOBmm, defaultProperties.get("Geboortedatum2").split(" ")[1]);
        selectDropdownByVisibleText(selectPassenger2DOByy, defaultProperties.get("Geboortedatum2").split(" ")[2]);
    }


    /**
     * getCredentials method will be called after adding patient and this will-
     * 1. capture credentials of newly created patients and update into hashmap
     * 2. Close the dialog box
     */


}
