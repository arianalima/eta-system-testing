package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.*;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

public class ListedBooksSteps {
    MainPage mainPage = new MainPage();
    Header header = mainPage.getHeader();
    ListedProductsPage resultsPage;
    LeftNavMenu leftNavMenu;
    LivrosPage livrosPage;

    public ListedBooksSteps(){
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

    @Given("The user access the {string} submenu {string}")
    public void theUserAccessTheMenu(String menu, String subMenu) {
        livrosPage = header.openMenu(menu);
        livrosPage.openSubMenu(subMenu);
    }

    @When("{string} department is chosen")
    public void someDepartmentIsChosen(String department) {
        leftNavMenu = livrosPage.getLeftNavMenu();
        resultsPage = leftNavMenu.openDepartment(department);
    }

    @Then("The books shown have a reduced price")
    public void theBooksShownHaveAReducedPrice() {
        try {
            LinkedHashMap<WebElement, List<List<Double>>> priceDict = resultsPage.getPrice(resultsPage.getResults());
            for (List<List<Double>> product: priceDict.values()) {
                for (List<Double> pairPrice: product) {
                    double currentPrice = pairPrice.get(0);
                    double formerPrice = pairPrice.get(1);
                    Assertions.assertTrue(currentPrice < formerPrice);
                }
            }
        } catch (ParseException e) {
            Assertions.fail("There is an invalid price in the products");
        }
    }
}
