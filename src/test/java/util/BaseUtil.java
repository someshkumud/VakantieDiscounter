package util;

/**
 * This class is created to define utility/supporting functions
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 06/06/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static util.DriverSetup.driver;

public class BaseUtil {

    public static HashMap<String, String> defaultProperties = new HashMap<String, String>();

    /**
     * loadDefaultProperties method will load properties from default.properties file into hash map
     */
    public static void loadDefaultProperties() {
        Properties properties = new Properties();
        readDefaultProperties(properties);
        processProperties(properties, defaultProperties);

    }

    /**
     * processProperties method created to support loadDefaultProperties, this will read properties from properties object and put into hash map
     */
    private static void processProperties(Properties properties, HashMap<String, String> default_properties) {
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            default_properties.put(key, value);
        }
    }

    /**
     * readDefaultProperties method created to support loadDefaultProperties, this will read properties from default.properties file and put into properties object
     */
    public static void readDefaultProperties(Properties properties) {
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
        webElement.click();
    }

    /**
     * selectDropdownByVisibleText method will select Dropdown value By Visible Text
     */
    public static void selectDropdownByVisibleText(WebElement webElementDropdown, WebElement value) {
        clickOn(webElementDropdown);
//        Wait(1);
        value.click();
    }

    public static void selectDropdownByValue(WebElement webElementDropdown, String value) {
        Select element = new Select(webElementDropdown);
        element.selectByValue(value);
    }


    public static void selectDropdownByVisibleText(WebElement webElementDropdown, String value) {
        Select element = new Select(webElementDropdown);
        element.selectByVisibleText(value);
    }

    public static void selectRadioButtonValue(List<WebElement> radioSalutation, String salutation) {
        if (radioSalutation.get(0).getText().equalsIgnoreCase(salutation)) {
            radioSalutation.get(0).click();
        } else {
            radioSalutation.get(1).click();
        }
    }

    public static void selectDateInCalander(WebElement calander, String value) {
        LocalDate today = LocalDate.now();
        int monthNow = today.getMonthValue();

        String arDate[] = value.split("/");
        int dd = Integer.parseInt(arDate[0]);
        int mm = Integer.parseInt(arDate[1]);
        if (mm > monthNow) {
            mm = mm - monthNow + 1;
        } else {
            mm = 12 - monthNow + mm + 1;
        }

        clickOn(calander);
//        Select Month
        driver.findElement(By.xpath("//div[@class=\"monthpicker\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"monthpicker\"]//a[" + mm + "]")).click();

        //****Select year
//        Not implemented

        //****Select Date
        //datePickerTable
        driver.findElement(By.xpath("//div[@class=\"dates\"]//span[contains(text(),'" + dd + "')]")).click();

    }
}

