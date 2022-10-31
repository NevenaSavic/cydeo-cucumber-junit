package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String string) {
        googleSearchPage.searchBox.sendKeys(string);
    }

    @Then("user sees {string} in the Google title")
    public void user_sees_in_the_google_title(String string) {
        String expectedTitle = "apple" + " - Google search";//sad je obaj apple deo promenljiv, ostalo je uvek isto
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }


    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        // Write code here that turns the phrase above into concrete actions
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    @Then("user sees apple in the Google title")
    public void user_sees_apple_in_the_google_title() {
        String expectedTitile = "apple - Google search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title is not as expected", actualTitle, expectedTitile);
        //ovaaj tekst ce biti napisan ako verifikacija fail
    }

}
