package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.Header;
import pages.ListedProductsPage;
import pages.MainPage;

public class SearchSteps {
    MainPage mainPage = new MainPage();
    Header header = mainPage.getHeader();
    ListedProductsPage resultsPage;

    public SearchSteps(){
        mainPage.accessPage();
    }

    @Given("The {string} category is selected")
    public void theCategoryIsSelected(String category) {
        if (!header.getSearchCategory().equals(category)){
            header.selectSearchCategory(category);
        }
    }

    @When("The user search for some {string}")
    public void theUserSearchForTheTerm(String term) {
        resultsPage = header.search(term);
    }

    @Then("The results shown are related to the {string}")
    public void theResultsShownAreRelatedToThe(String term) {
        for (WebElement result: resultsPage.getResults()){
            String resultText = result.getText().toLowerCase();
            Assertions.assertTrue(resultText.contains(term.toLowerCase()), result.getText().toLowerCase());
        }
    }

}
