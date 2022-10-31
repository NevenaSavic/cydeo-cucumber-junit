package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTables {

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println(fruits);
        System.out.println(fruits.get(1));//vraca voce na indeksu 1
}




    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

      //napravimo objekat da pokupimo podatke, sta sadrzi od podataka
    DropdownsPage dropdownsPage = new DropdownsPage();

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

        //uz pomoc Select radimo dropdowns
        Select select = new Select(dropdownsPage.monthDropDown);
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

        Assert.assertEquals(expectedMonths, actualOptionsAsString);
        //ovo ce proveriti velicinu liste prvo, ako mecuje onda ce proveriti sadrzaj 1 po 1
    }
}
