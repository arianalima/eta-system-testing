package stepDefinitions;

import helpers.DriverManager;
import org.junit.After;
import org.junit.Before;

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
