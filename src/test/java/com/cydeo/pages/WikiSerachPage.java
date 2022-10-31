package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSerachPage {

    public WikiSerachPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "searchInput")
    public WebElement searchBox;

    @FindBy(using = "//button[@type='submit']")
    public WebElement searchButton;


    @FindBy(id = "firstHeading")
    public WebElement mainHeader;


}
