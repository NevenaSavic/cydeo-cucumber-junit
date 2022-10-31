package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSerachPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiSerachPage wikiSerachPage = new WikiSerachPage(); //pravi objekat ovog class da bismo pozivali @FindBy anotacije odatle

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("htpps://www.wikipedia.org");
    }
    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikiSerachPage.searchBox.sendKeys(string);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSerachPage.searchButton.click();
    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {

       Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }




    @Then("User types Steve Jobs in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees {string} is in the main header")
    public void user_sees_steve_jobs_is_in_the_main_header(String string) {

        Assert.assertTrue(wikiSerachPage.mainHeader.isDisplayed());
        Assert.assertTrue(wikiSerachPage.mainHeader.getText().equals(string));
    }



}
