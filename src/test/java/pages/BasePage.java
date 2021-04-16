package pages;

import helpers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public BasePage(){
        this.driver = DriverManager.getDriver();
        this.driverWait = DriverManager.getDriverWait();
    }

    public void accessPage(String url){
        this.driver.get(url);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public WebElement findElement(By cssSelector){
        return this.driver.findElement(cssSelector);
    }

    public List<WebElement> findElements(By cssSelector){
        return this.driver.findElements(cssSelector);
    }

    public void setDriverWaitVisibility(WebElement element){
        this.driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setDriverWaitVisibility(By selector){
        this.driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public void clickElement(WebElement element){
        setDriverWaitVisibility(element);
        element.click();
    }

    public boolean isElementVisible(By cssSelector){
        return findElement(cssSelector).isDisplayed();
    }
}
