package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.Constants.CHROME_DRIVER_PATH;

public class DriverManager {
    private static WebDriver driver;
    private static WebDriverWait driverWait;
    private static ChromeOptions options;

    public static WebDriver getDriver(){
        String chromeDriverExtension = "";
        if (System.getProperty("os.name").startsWith("Windows")){
            chromeDriverExtension = ".exe";
        }
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH + chromeDriverExtension);
        if (driver == null){
            options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static WebDriverWait getDriverWait(){
        if (driverWait == null){
            driverWait = new WebDriverWait(driver, 20);
        }
        return driverWait;
    }

    public static void endSession(){
        if (driver != null){
            driver.quit();
            driver = null;
            driverWait = null;
        }
    }
}
