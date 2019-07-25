package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * This class is created to define page objects and methods of Overview And Payment Page in VakantieDiscounter application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */

public class OverviewAndPaymentPage {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public OverviewAndPaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//table[@class='the-total']//span[@class='price-rowtotal']")
    private WebElement labelTotalPriceEuros;

    @FindBy(how = How.XPATH, using = "//table[@class='the-total']//span[@class='price-rowtotal-decimals']")
    private WebElement labelTotalPriceCents;

    /**
     * getTotalPrice method will read total price from screen and return as Float
     */
    public float getTotalPrice() {
        String totalPrice = labelTotalPriceEuros.getText().replace(".", "") + "." + labelTotalPriceCents.getText();
        System.out.println(totalPrice);
        return Float.parseFloat(totalPrice);
    }
}
