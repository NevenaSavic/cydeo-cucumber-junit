package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

      /*
    this method will accept int(in seconds) and execute Thread.sleep for given duration
     */

    public void sleep(int second){
        second *= 1000;

        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }


    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles){
            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("Etsy")){
                break;
            }
        }

        //Assert
        String actualTitle = driver.getTitle();
        String expectedTitle1 = "Etsy";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    //this method accepts a String expectedTitle and Asserts if is it true
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }


    //creating a method for explicit wait, so we do not make it every time
    public static void waitForInvisibilityFor(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), TimeUnit.SECONDS.ordinal()); //sta je ovo ordinal?
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }


    public static void verifyTitleContains(String expectedInUrl){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }


    //hocemo da prihvati kao argument list of web element i da vrati list of string
    public static List<String> convertDropDownToString(List<WebElement> dropDownElement){

        //uz pomoc Select radimo dropdowns
        Select select = new Select((WebElement) dropDownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        /*
        imamo konflikt, list string i list of web element
        treba da sacuvamo u praznom stringu sve opcije iz ovog web element
        we pass all of the actual web element options
         */

        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) { //ovo ce vratiti tekst svake opcije, januar, februar, mart, april itd.
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }



    /*
    ova metoda ce prihvatiti group of radio buttons kao listu web elemenata
    proci ce kroz listu i kliknuce na radio button sa tom atribute value
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String atributValue){

        for (WebElement each:radioButtons) {

            if (each.getAttribute("value").equals(atributValue)){
                each.click();
            }

        }
    }







}
