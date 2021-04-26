package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.ChooseAddressPopup;
import pages.Header;
import pages.MainPage;

public class ChooseAddressSteps {
    MainPage mainPage;
    Header header;
    ChooseAddressPopup popup;
    String error;

    public ChooseAddressSteps(){
        mainPage = new MainPage();
        header = mainPage.getHeader();
        mainPage.accessPage();
    }

    @Given("The popup to choose the address is open")
    public void theUserOpensThePopupToChooseTheAddress() {
        popup = header.openChooseAddressPopup();
    }

    @Given("The user inserts some {string} {string}")
    public void theUserInsertsSome(String zipCodePart1, String zipCodePart2) {
        popup.insertZipCode(zipCodePart1, zipCodePart2);
    }

    @When("The user sends the information")
    public void theUserSendsTheInformation() {
        error = popup.sendZipCode();
    }

    @Then("An error is shown")
    public void AnErrorIsShown() {
        Assertions.assertEquals("Insira um CEP válido", error);
    }
}
