package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    //pravimo objekat sa ovim sto smo vec napravili, da iskoristimo vec napravljenu log in metodu
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();

    OrderPage orderPage = new OrderPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));

        //calling our order method to log in to the table app
      webTableLoginPage.login();

      //clicking to order link to go to order page
      basePage.order.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.productDropDown);  //na web stranici je dropdown gde biramo izmedju vise opcija, zato koristimo select
        select.selectByVisibleText(string);
    }

    /*@When("user enters quantity {string}")
    public void user_enters_quantity(String string) {

    }
     */

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {

        //kako da obrisemo nesto, isto dva nacina
        orderPage.inputQuantity.clear(); //ovo nekad ne radi
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);


        //dva nacina za ovo
        orderPage.inputQuantity.sendKeys(arg0+" ");
        orderPage.inputQuantity.sendKeys(String.valueOf(arg0));
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        orderPage.inputName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
       orderPage.inputCity.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
       orderPage.inputState.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
       orderPage.inputZip.sendKeys(string);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
        BrowserUtils.clickRadioButton(orderPage.cardType, expectedCardType); //this line will loop through list and decide which radio button should be clicked
    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardNoInput.sendKeys(string);
    }

    @When("user enters expire date {string}")
    public void user_enters_expire_date(String string) {
        orderPage.cardExpInput.sendKeys(string);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processButton.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

        String actualname = viewAllOrdersPage.newCustomerCell.getText();

        Assert.assertEquals(actualname, expectedName);

    }


}
