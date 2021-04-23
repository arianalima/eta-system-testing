package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeftNavMenu extends BasePage{
    private By departmentsSelector = By.cssSelector(".apb-browse-refinements-indent-2 a");

    public ListedProductsPage openDepartment(String department){
        ListedProductsPage listedProductsPage = null;
        List<WebElement> departments = super.findElements(departmentsSelector);
        for (WebElement dept:departments) {
            if (dept.getText().toLowerCase().equals(department.toLowerCase())){
                dept.click();
                listedProductsPage = new ListedProductsPage();
                break;
            }
        }
        return listedProductsPage;
    }
}
