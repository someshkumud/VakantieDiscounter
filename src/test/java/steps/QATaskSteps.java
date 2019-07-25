package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;

import static util.BaseUtil.defaultProperties;
import static util.BaseUtil.loadDefaultProperties;
import static util.DriverSetup.*;

/**
 * This class is created to define test steps against steps mentioned in feature files
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */

public class QATaskSteps {

    /**
     * @Before hook will execute before scenario and  load default properties file into hashmap
     */
    @Before
    public void InitializeTest() {
        loadDefaultProperties();
    }

    /**
     * @After hook will execute after execution of scenario and  -
     * 1. will print failed scenarios name on console
     * 2. Close browser after scenario
     */
    @After
    public void TearDownTest(Scenario scenario) {
        try {
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (scenario.isFailed()) {
            System.out.println("SCENARIO FAILED : " + scenario.getName());
        } else {
            System.out.println("SCENARIO PASSED : " + scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        closeDriver();
    }

    @Given("^Launch browser and navigate to Homepage$")
    public void launchBrowserAndNavigateToHomepage() {
        createDriver();
        driver.get(defaultProperties.get("url"));
    }

    @And("^Navigate to Sun Vertical page$")
    public void navigateToSunVerticalPage() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToSunVertical();
    }

    @And("^Set \"([^\"]*)\" as \"([^\"]*)\"$")
    public void setAs(String key, String value) {
        defaultProperties.put(key, value);
    }

    @And("^Search Holiday$")
    public void searchHoliday() {
        SunVerticalPage sunVerticalPage = new SunVerticalPage(driver);
        sunVerticalPage.searchHoliday();
    }

    @And("^Filter search result$")
    public void filterSearchResult() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.filterSearchResults();
    }

    @And("^Select package available at index (\\d+)$")
    public void selectPackageAvailableAtIndex(int arg0) {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.selectPackageByIndex(arg0);
    }

    @And("^Navigate to Check Price page$")
    public void navigateToCheckPricePage() {
        OfferDetailsPage offerDetailsPage = new OfferDetailsPage(driver);
        offerDetailsPage.checkPrice();
    }

    @And("^Enter Traveler Details$")
    public void enterTravelerDetails() {
        BookFlowPage bookFlowPage = new BookFlowPage(driver);
        bookFlowPage.enterTravelerDetails();
    }

    @And("^Confirm application details$")
    public void confirmApplicationDetails() {
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.confirmDetails();
    }

    @And("^Move to Step 3$")
    public void moveToStep() {
        AdditionalOptionPage additionalOptionPage = new AdditionalOptionPage(driver);
        additionalOptionPage.navigateToStep3();
    }

    @Then("^Final price matches with price on checkout screen$")
    public void finalPriceMatchesWithPriceOnCheckoutScreen() {
        OverviewAndPaymentPage overviewAndPaymentPage = new OverviewAndPaymentPage(driver);
        Assert.assertEquals(overviewAndPaymentPage.getTotalPrice(), Float.parseFloat(defaultProperties.get("checkoutPrice")), 0.001);
    }
}
