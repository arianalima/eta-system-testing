package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{

    private By menuSelector = By.cssSelector("#nav-hamburger-menu");

    public Header getHeader(){
        return new Header();
    }

    @Test
    public void accessPage(){
        super.accessPage("https://www.amazon.com.br/");
    }

    public void openMenu(){
        WebElement menu = findElement(menuSelector);
        clickElement(menu);
    }

}
