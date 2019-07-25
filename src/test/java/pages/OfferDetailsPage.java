package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static util.BaseUtil.clickOn;
import static util.BaseUtil.defaultProperties;


/**
 * This class is created to define page objects and methods of Offer Details Page in VakantieDiscounter application
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

    @FindBy(how = How.XPATH, using = "//p[@class='price no-marker with-info']/span[@class='price-number']")
    private WebElement labelCheckoutPriceEuro;

    @FindBy(how = How.XPATH, using = "//p[@class='price no-marker with-info']/span[@class='price-decimals']")
    private WebElement labelCheckoutPriceCents;

    /**
     * checkPrice method will -
     * 1. Click on Check Price button
     * 2. Save price on checkout screen in Hash-Map
     * 3. Clicks on Book Now button
     */
    public void checkPrice() {
        clickOn(btnCheckPrice);
        getCheckoutPrice();
        clickOn(btnBookNow);
    }

    /**
     * getCheckoutPrice method will save total price on checkout screen in Hash-Map
     */
    private void getCheckoutPrice() {
        defaultProperties.put("checkoutPrice", labelCheckoutPriceEuro.getText().replace(",", "").replace(".", "") + "." + labelCheckoutPriceCents.getText());
    }

}
