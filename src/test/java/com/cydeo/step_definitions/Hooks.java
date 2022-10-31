package com.cydeo.step_definitions;

//in this scenario we will be able to pass pre- and post- conditions to each scenario and each step

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 1)
    public void setUpScenario(){
        System.out.println("===Setting up browser using cucumber @Before");
    }


    @Before(value = "@login", order = 2) //kojim redosledom se izvrasavaju
    public void setUpScenarioForLogins(){
        System.out.println("===Setting up browser using cucumber @Before");
    }

    @Before(value = "@db", order = -1)
    public void setUpForDataBaseScenarios(){
        System.out.println("===this will only apply to scenarios with @db tag");
    }


    @After
    public void tearDownScenario(Scenario scenario){ //prati onaj scenario sto pravimo u drugom class

        //if scenario.isFaild it will retur true booleadn value

        if(scenario.isFailed()){
            //SCREENSHOT se ovako radi
            byte [] schreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(schreenshot, "image/png", scenario.getName() );

        }


        //System.out.println("===Closing browser using cucumber After");
        //System.out.println("===Scenario ended/ Take screenshot is failed");
    }


    @BeforeStep
    public void setUpStep(){
        System.out.println("--------------applying setup using @BeforeStep");
    }


    @AfterStep
    public void afterStep(){
        System.out.println("---------------applying tearDown using@AfterStep");
    }
}
