package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseAddressPopup extends BasePage{
    private By zipCodeInputSelector = By.cssSelector("[data-action=GLUXPostalInputAction]");
    private By confirmButtonSelector = By.cssSelector("#GLUXZipInputSection .a-button-input");
    private By errorMessageSelector = By.cssSelector("#GLUXZipError");


    public void insertZipCode(String zipCodePart1, String zipCodePart2){
        super.setDriverWaitVisibility(zipCodeInputSelector);
        List<WebElement> zipCodeInput = super.findElements(zipCodeInputSelector);
        zipCodeInput.get(0).sendKeys(zipCodePart1);
        zipCodeInput.get(1).sendKeys(zipCodePart2);
    }

    public String sendZipCode(){
        super.findElement(confirmButtonSelector).click();
        WebElement errorMessage = super.findElement(errorMessageSelector);
        super.setDriverWaitVisibility(errorMessage);
        if (errorMessage.isDisplayed()){
            return errorMessage.getText();
        }
        return "";
    }

}
