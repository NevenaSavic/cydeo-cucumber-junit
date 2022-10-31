package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTable_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
       String url = ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);
    }
    @When("user enters {string}")
    public void user_enters(String string) {
        webTableLoginPage.inputUsername.sendKeys(string);
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyTitleContains("order");
    }


    @When("user enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String username, String password) {
       /* webTableLoginPage.inputUsername.sendKeys(username);
        webTableLoginPage.inputPassword.sendKeys(password);
        webTableLoginPage.loginButton.click();
        */

        webTableLoginPage.login(username, password);
    }


    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentials) {
       //radimo kao mape key je username, value je test
        credentials.get("username");
        credentials.get("password");

        webTableLoginPage.inputUsername.sendKeys(credentials.get("username"));
        webTableLoginPage.inputPassword.sendKeys(credentials.get("password"));

        //ili mozemo da koristimo vec napravljenu metodu
        webTableLoginPage.login(credentials.get("username"), credentials.get("password"));

    }

}
