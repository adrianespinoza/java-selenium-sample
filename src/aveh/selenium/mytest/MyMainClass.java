package aveh.selenium.mytest;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MyMainClass {
    public static void main(String[] args) {
        // The Firefox driver supports javascript

        /*
        WebDriver driver = new FirefoxDriver();*/


        /*
        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://test.salesforce.com/");

        MyUtils.Login("adrian@jalasoft.com.adrian01", "Admin1234", driver);
        MyUtils.GoToITinvolveApp(driver);
        MyUtils.GoToITinvolveTab("Main App", driver);
        MyUtils.GoToITinvolveTab("Browse All", driver);*/

        //MyUtils.GoToITinvolveTab("Changes", driver);
        //MyUtils.GoToITinvolveTabSelectAllByHref("apex/ListChange", driver);

        /*MyUtils.GoToITinvolvePageFromMenu("ListChange", "Change", driver, false);

        //MyUtils.DoWork1(driver);

        MyUtils.DoWork2(driver);*/

        /*// Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        List<WebElement> webElements = driver.findElements(By
                .xpath("//ul[@class='nav logged_out']/li"));
        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed()) {
              break;
            }
        }

        // And now list the suggestions
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));

        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }*/
        //driver.navigate().to("https://login.salesforce.com/");

        //My other test
        // Create a new instance of a driver
        WebDriver driver = new FirefoxDriver();

        // Navigate to the right place
        driver.get("http://www.google.com/");

        // Create a new instance of the search page class
        // and initialise any WebElement fields in it.
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);

        // And now do the search.
        page.searchFor("Cheese");

    }
}
