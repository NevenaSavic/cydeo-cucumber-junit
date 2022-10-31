package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement inputUsername;


    @FindBy(name = "password")
    public WebElement inputPassword;


    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;


    /**
     * kad pozovemo ovu metodu ona ce da se uloguje sa imenom Test i sifra Tester; this se odnosi na objekat,
     * prvo objekat zovemo
     * to this nije obavezno da se stavi!
     */
    public void login(){
      this.inputUsername.sendKeys("Test");
      this.inputPassword.sendKeys("Tester");
      this.loginButton.click();
    }

    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }


    /*
    citamo direktno iz cong.properties
     */
    public void loginWithConfig(){
        inputUsername.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("web.table.pw"));
        loginButton.click();
    }










}
