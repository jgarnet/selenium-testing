
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GrowthCalculatorTest {
    
    private static final String INVESTMENT = "investment";
    private static final String YEARS = "years";
    private static final String RECURRING = "recurring";
    private static final String RATE = "rate";
    private static final String CALCULATE = "calculate";
    private static final String AMOUNT = "amount";
    
    private WebDriver acquireDriver(String URL) {
        WebDriver browser = new ChromeDriver();
        browser.get(URL);
        return browser;
    }
    
    private Map<String, WebElement> getElements(WebDriver browser) {
        Map map = new HashMap<String, WebElement>();
        map.put(INVESTMENT, browser.findElement(By.id("investment")));
        map.put(YEARS, browser.findElement(By.id("years")));
        map.put(RECURRING, browser.findElement(By.name("recurring")));
        map.put(RATE, browser.findElement(By.id("rate")));
        map.put(CALCULATE, browser.findElement(By.id("calculateBtn")));
        map.put(AMOUNT, browser.findElement(By.id("amount")));
        return map;
    }
    
    private void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
    
    @Test
    public void testCan_Calculate_One_Year() {
        WebDriver browser = acquireDriver("C:\\Users\\jgarn\\Documents\\dev\\js\\growth_estimator.html");
        
        Map<String, WebElement> elements = getElements(browser);
        
        type(elements.get(INVESTMENT), "1000");
        type(elements.get(YEARS), "1");
        type(elements.get(RATE), ".07");
        elements.get(CALCULATE).click();
        
        String value = elements.get(AMOUNT).getText();
        
        assertTrue("1070.00".equals(value));

        browser.close();
    }
}
