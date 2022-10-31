package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    creating a private constructor, so we are closing access to the object of this class from outside the class
     */

    private Driver(){}

    //we make web driver private because we want to close access from outside of the class
    //private static WebDriver driver; ovo je kad pravimo obicno

    //ovo je za paralelno testiranje
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    //create a reusable utility method which will return same driver instance when we call it
    public static WebDriver getDriver(){

        if(driverPool.get()==null){ //kad je obicno onda pisemo driver == null

            //We read our browser from configuration.properties
            //This way we control which browser is opened from outside of our code, from configuration.properties
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();

        //this method will make sure that a driver is always null after using quit() method
        /*public static void closeDriver(){
            if (driverPool.get() != null){
                driverPool.get().quit(); //this line will terminate the existing session. value will not even be null
                driverPool.remove();
            }
        }
         */

    }







}
