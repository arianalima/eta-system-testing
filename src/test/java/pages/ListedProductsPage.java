package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class ListedProductsPage extends BasePage{
    private By resultSelector = By.cssSelector(".s-main-slot > .s-result-item:not(.AdHolder):not(:nth-last-child(-n+3))");
    private By priceSelector = By.cssSelector(".a-offscreen");

    public List<WebElement> getResults(){
        return super.findElements(resultSelector);
    }

    public LinkedHashMap<WebElement, List<List<Double>>> getPrice(List<WebElement> results) throws ParseException {
        LinkedHashMap<WebElement, List<List<Double>>> priceDict = new LinkedHashMap<WebElement, List<List<Double>>>();
        for (WebElement product:results) {
            List<WebElement> productPrices = product.findElements(priceSelector);
            List<List<Double>> prices = new ArrayList<List<Double>>();
            for (int i = 0; i <= productPrices.size()/2; i += 2) {
                List<Double> pricePair = new ArrayList<Double>();
                String currentPrice = productPrices.get(i).getAttribute("textContent").split("R\\$ ")[1];
                String oldPrice = productPrices.get(i+1).getAttribute("textContent").split("R\\$ ")[1];
                pricePair.add(getDoubleValue(currentPrice));
                pricePair.add(getDoubleValue(oldPrice));
                prices.add(pricePair);
            }
            priceDict.put(product,prices);
        }
        return priceDict;
    }

    private double getDoubleValue(String stringValue) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = format.parse(stringValue);
        return number.doubleValue();
    }
}
