package stepDefinitions;

import helpers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario(){
        DriverManager.getDriver();
        DriverManager.getDriverWait();
    }

     @After
     public void afterScenario(){
         DriverManager.endSession();
     }
}
