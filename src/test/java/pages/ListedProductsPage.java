package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListedProductsPage extends BasePage{
    private By resultSelector = By.cssSelector(".s-main-slot > .s-result-item:not(.AdHolder):not(:nth-last-child(-n+3))");

    public List<WebElement> getResults(){
        return super.findElements(resultSelector);
    }

}
