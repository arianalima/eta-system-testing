package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Header extends BasePage{
    private By categorySelector = By.cssSelector("#searchDropdownBox");
    private By categoryOptionsSelector = By.cssSelector("option");
    private By searchFieldSelector = By.cssSelector("#twotabsearchtextbox");
    private By searchBtnSelector = By.cssSelector("#nav-search-submit-button");

    public void selectSearchCategory(String category){
        WebElement categoryBtn = super.findElement(categorySelector);
        categoryBtn.click();
        List<WebElement> categoryOptions = categoryBtn.findElements(categoryOptionsSelector);
        for (WebElement c:categoryOptions) {
            if (c.getText().equals(category)){
                c.click();
                break;
            }
        }
    }

    public ListedProductsPage search(String term){
        WebElement searchField = super.findElement(searchFieldSelector);
        searchField.sendKeys(term);
        super.findElement(searchBtnSelector).click();
        return new ListedProductsPage();
    }

    public String getSearchCategory() {
        return super.findElement(categorySelector).getText();
    }
}
