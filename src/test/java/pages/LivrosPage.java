package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LivrosPage extends BasePage{
    private By subMenuSelector = By.cssSelector("#nav-progressive-subnav .nav-a-content");

    public LeftNavMenu getLeftNavMenu(){
        return new LeftNavMenu();
    }

    public void openSubMenu(String title){
        List<WebElement> subMenu = super.findElements(subMenuSelector);
        for (WebElement menu: subMenu) {
            if (menu.getText().toLowerCase().equals(title.toLowerCase())){
                menu.click();
                break;
            }
        }
    }
}
