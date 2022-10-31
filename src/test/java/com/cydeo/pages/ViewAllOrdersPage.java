package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllOrdersPage extends BasePage {

    public ViewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //trazimo prvi red i prvu celiku, jer treba tu da nam pise Serlok Holmes
    @FindBy(xpath = "//table[@class='table is-fullwidth']/tbody/tr[1]/td[1]")
    public WebElement newCustomerCell;


}
