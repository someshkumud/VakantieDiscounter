package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static util.DriverSetup.driver;

/**
 * This class is created to define utility/supporting functions
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 22/07/2019
 */
public class BaseUtil {

    public static HashMap<String, String> defaultProperties = new HashMap<>();

    /**
     * loadDefaultProperties method will load properties from default.properties file into hash map
     */
    public static void loadDefaultProperties() {
        Properties properties = new Properties();
        readDefaultProperties(properties);
        processProperties(properties, defaultProperties);
    }

    /**
     * processProperties method created to support loadDefaultProperties,
     * this will read properties from properties object and put into hash map
     */
    private static void processProperties(Properties properties, HashMap<String, String> default_properties) {
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            default_properties.put(key, value);
        }
    }

    /**
     * readDefaultProperties method created to support loadDefaultProperties,
     * this will read properties from default.properties file and put into properties object
     */
    private static void readDefaultProperties(Properties properties) {
        FileInputStream input = null;
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\config\\default.properties");
            input = new FileInputStream(file);
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * Even though use of static wait is bad practice from automations point of view
     * But this method is created to save time
     * Wait method will allow wait till specified time (in seconds)
     */
    public static void Wait(int timeInSec) {
        try {
            Thread.sleep(timeInSec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * enterValueInTextBox method will enter Value In TextBox
     *
     * @param webElement object of text box
     */
    public static void enterValueInTextBox(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    /**
     * clickOn method will click on links/button
     *
     * @param webElement object of link/button
     */
    public static void clickOn(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    /**
     * clickOnElementAction method will click on links/button
     * this method is created to handle object which are not clickable
     *
     * @param webElement object of link/button
     */
    public static void clickOnElementAction(WebElement webElement) {
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement).click().perform();
    }

    /**
     * selectDropdownByVisibleText method is created to select dropdown which are not of type select
     * this method will select Dropdown value By Visible Text
     *
     * @param webElementDropdown object of dropdown
     * @param value              object of list (after clicking dropdown)
     */
    public static void selectDropdownByVisibleText(WebElement webElementDropdown, WebElement value) {
        clickOn(webElementDropdown);
        value.click();
    }

    /**
     * selectDropdownByVisibleText method will select Dropdown by its value
     *
     * @param webElementDropdown object of dropdown
     * @param value              String value of item to be selected from list
     */
    public static void selectDropdownByValue(WebElement webElementDropdown, String value) {
        Select element = new Select(webElementDropdown);
        element.selectByValue(value);
    }

    /**
     * selectDropdownByVisibleText method will select Dropdown value by visible text
     *
     * @param webElementDropdown object of dropdown
     * @param value              String value of item to be selected from list
     */
    public static void selectDropdownByVisibleText(WebElement webElementDropdown, String value) {
        Select element = new Select(webElementDropdown);
        element.selectByVisibleText(value);
    }

    /**
     * selectRadioButtonValue method will select Dropdown value by visible text
     *
     * @param radioButtons List<WebElements> object of radio buttons
     * @param value        String value of item to be selected from list
     */
    public static void selectRadioButtonValue(List<WebElement> radioButtons, String value) {
        for (WebElement radio : radioButtons) {
            if (radio.getText().equalsIgnoreCase(value)) {
                radio.click();
                break;
            }
        }
    }

    /**
     * selectDateInCalender method will select dd, mm, yyyy from calender picker
     *
     * @param calender WebElements object of calender icon/button
     * @param value    String value of date in format dd/mm/yyyy
     */
    public static void selectDateInCalender(WebElement calender, String value) {
        LocalDate today = LocalDate.now();
        int monthNow = today.getMonthValue();

        String[] arDate = value.split("/");
        int dd = Integer.parseInt(arDate[0]);
        int mm = Integer.parseInt(arDate[1]);
        if (mm > monthNow) {
            mm = mm - monthNow + 1;
        } else {
            mm = 12 - monthNow + mm + 1;
        }

        clickOn(calender);
//***************************Select Month
        Wait(1);
        driver.findElement(By.xpath("//div[@class='monthpicker']")).click();
        driver.findElement(By.xpath("//div[@class='monthpicker']//a[" + mm + "]")).click();

//***************************Select year : Not implemented for demo project

//***************************Select Date
        driver.findElement(By.xpath("//div[@class='dates']//span[contains(text(),'" + dd + "')]")).click();
    }
}

