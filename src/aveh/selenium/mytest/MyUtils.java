package aveh.selenium.mytest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class MyUtils {

    public static WebDriverWait wait;
    public static void Login(String usrName, String pw, WebDriver driver)
    {
        WebElement query = driver.findElement(By.name("username"));
        query.sendKeys(usrName);

        query = driver.findElement(By.name("pw"));
        query.sendKeys(pw);

        query.submit();
    }
    public static void GoToITinvolveApp(WebDriver driver)
    {
        //first time
        wait= new WebDriverWait(driver, 30);
        WaitForPageLoaded();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='tsidLabel']")));
        String menuSelected = driver.findElement(By.xpath("//span[@id='tsidLabel']")).getText();
        if ( !menuSelected.contains("ITinvolve") ) {
            System.out.println("Into app");
            driver.findElement(By.id("tsidButton")).click();
            try {
                MyUtils.sleeptime(1000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//a[contains(text(),'ITinvolve')]")).click();
        }

    }
    public static void GoToITinvolveTab(String tabText, WebDriver driver)
    {
        //WaitForPageLoaded(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + tabText + "')]")));
        driver.findElement(By.xpath("//a[contains(text(),'" + tabText + "')]")).click();
        try {
            MyUtils.sleeptime(1000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void GoToITinvolveTabSelectAllByHref(String text, WebDriver driver)
    {
        /*try {
            MyUtils.sleeptime(5000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        //ul[@class='featureList' and ./li[contains(.,'Model')]]

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'" + text + "')]")));
        //driver.findElement(By.xpath("//a[contains(@href,'" + text + "')]")).click();
        //WebElement elem = driver.findElement(By.xpath("//li[3]/div/table/tbody/tr[2]/td/ul/li[2]/a[contains(text(),'Changes')]"));
        //elem.click();
        //System.out.println(elem);
        /**/
        //List<WebElement> allSuggestions = driver.findElements(By.xpath("//div[@class='pulldown multicolumn']"));
        //WebElement allSuggestions = driver.findElement(By.xpath("//div[@class='pulldown multicolumn']"));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='toplevel enableMenus' and ./div[@class='pulldown multicolumn']]")));


        /*List<WebElement> allSuggestions = driver.findElements(By.xpath("//a[contains(text(),'Changes')]"));
        System.out.println(allSuggestions.size());
        allSuggestions.get(1).click();*/

        //String href=driver.findElement(By.xpath("//a[contains(@href,'/staff/transcript/')][contains(@href,'.pdf')]")).getAttribute("href");

        List<WebElement> allElementsList = driver.findElements(By.xpath("//a[contains(@href,'/apex/ListChange') and contains(text(),'Changes')]"));
        String href = "";
        for (WebElement element : allElementsList)
        {
            href = element.getAttribute("href");
            if (href.endsWith("ListChange") && element.isDisplayed())
            {
                System.out.println(element);
                ClickOnElement(element, driver);
                break;
            }
        }

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Changes']")));
        //WebElement child = allSuggestions.get(1).findElement(By.xpath("//a[text() = 'Changes']"));
        //System.out.println(child);
        //child.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Changes']")));

        //WebElement child = driver.findElement(By.xpath("//a[text() = 'Changes']"));
        //System.out.println(child);
        //child.click();

        //WebElement elem = driver.findElement(By.xpath("//li[3]/div/table/tbody/tr[2]/td/ul/li[2]/a[contains(text(),'Changes')]"));
        //System.out.println(elem);
        //elem.click();
        //System.out.println("Size: " + allSuggestions.size());
        //for (WebElement suggestion : allSuggestions) {
            //WebElement child = suggestion.findElement(By.xpath("//a[contains(text(),'Changes')]"));
            //child.click();
            //System.out.println(child);
        //}
    }

    public static void GoToITinvolvePageFromMenu(String pageName, String labelText, WebDriver driver, Boolean applyEndWithPageName)
    {
        List<WebElement> allElementsList = driver.findElements(By.xpath("//a[contains(@href,'/apex/" + pageName + "') and contains(text(),'" + labelText + "')]"));
        String href = "";
        Boolean elementWasLocated = false;
        for (WebElement element : allElementsList)
        {
            if (element.isDisplayed() && applyEndWithPageName)
            {
                href = element.getAttribute("href");
                if (href.endsWith("ListChange"))
                {
                    elementWasLocated = true;
                }
            }
            else if (element.isDisplayed())
            {
                elementWasLocated = true;
            }

            if (elementWasLocated)
            {
                ClickOnElement(element, driver);
                break;
            }
        }
    }
    public static void ClickOnElement(WebElement element, WebDriver driver)
    {
        /*JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        new Actions(driver).moveToElement(element).click().perform();
        element.click();*/
        new Actions(driver).moveToElement(element, 10, 10).click().perform();
    }
    public static void DobleClickOnElement(WebElement element, WebDriver driver)
    {
        new Actions(driver).moveToElement(element).doubleClick().perform();
    }
    public static void sleeptime(int time ) throws Exception {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void DoWork1(WebDriver driver)
    {
        try {

            EnterFirstValueChanges(driver);

            List<String> parameterList = new ArrayList<String>();
            parameterList.add("Adrian");
            parameterList.add("Espinoza");
            SetValueOnInlineEditFieldChangesBasic(2, 2, parameterList, driver);

        } catch (Throwable e) {
            System.out.println("click_on_element Failed!" + e);
        }
    }
    public static void DoWork2(WebDriver driver)
    {

        EnterFirstValueChanges(driver);
        try {
            String xpathMainTable = "//body/div[@class = 'wrapper container-wrap']/.//table[@class = 'rich-tabpanel ']";
            WaitForPageLoaded();
            List<WebElement> elem1 = GetElementByTagFromDriver(driver, "div", "class", "pagetabnav_content");
            System.out.println("Elem1: " + elem1.size());
            List<WebElement> elem2 = GetElementByTagFromWebElement(elem1.get(0), "table", "class", "detailList");
            System.out.println("Elem2: " + elem2.size());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void EnterFirstValueChanges(WebDriver driver)
    {
        WaitForPageLoaded();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/tr[1]/td[4]/a")));
        WebElement element;
        try {
            element=driver.findElement(By.xpath("//*/tr[1]/td[4]/a"));
            if (element.isDisplayed())
            {
                element.click();
            }
        } catch (Exception e) {
        }
    }
    public static void SetValueOnInlineEditFieldChangesBasic(Integer row, Integer columns, List<String> valuesRowByColumn, WebDriver driver)
    {
        try {
            String xPathExpression = "//table[@class = 'rich-tabpanel-content-position']/tbody/tr[1]/td[1]/div[1]/.//div[@class = 'pbBody']/div[1]/div[@class = 'pbSubsection']/table[@class = 'detailList']/tbody/tr[" + row + "]/td[@class = 'dataCol ']/span/span";
            WaitForPageLoaded();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathExpression)));

            List<WebElement> elements = driver.findElements(By.xpath(xPathExpression));
            System.out.println("click_on_element!: " + elements.size());
            for (Integer column = 0; column < columns; column++)
            {
                if (elements.get(column).isDisplayed())
                {
                    DobleClickOnElement(elements.get(column), driver);
                }

                MyUtils.sleeptime(3000);

                String xPathSub = ".//table/tbody/tr[1]/td[2]/.//input";
                String xPathConcat = xPathExpression + "/" + xPathSub;

                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathConcat)));

                List<WebElement> subElement = elements.get(column).findElements(By.xpath(xPathSub));
                System.out.println(subElement.size());
                System.out.println(subElement.get(0).isDisplayed());
                if (subElement.get(0).isDisplayed())
                {
                    subElement.get(0).clear();
                    subElement.get(0).sendKeys(valuesRowByColumn.get(column));
                }
                MyUtils.sleeptime(3000);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void WaitForPageLoaded()
    {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(WebDriver driver)
            {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        //Wait<WebDriver> wait = new WebDriverWait(driver,30);
        try {
                wait.until(expectation);
        } catch(Throwable error) {
                System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }
    public static void WaitForPageLoadedAndElementLocated(By expresionBy)
    {
        WaitForPageLoaded();
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(expresionBy));
        } catch (Exception e)
        {
            System.out.println("WaitForPageLoadedAndElementLocated");
        }
    }

    public static List<WebElement> GetElementByTagFromDriver(WebDriver driver, String tag, String attName, String attValue)
    {
        try {
            String xpath = ".//" + tag + "[@" + attName + "='" + attValue + "']";
            System.out.println(xpath);
            //WaitForPageLoaded();
            WaitForPageLoadedAndElementLocated(By.xpath(xpath));
            List<WebElement> elementsDivList = driver.findElements(By.xpath(xpath));
            return elementsDivList;
        } catch (Exception e) {
            return null;
        }

    }
    public static List<WebElement> GetElementByTagFromWebElement(WebElement element, String tag, String attName, String attValue)
    {
        try {
            String xpath = ".//" + tag + "[@" + attName + "='" + attValue + "']";
            System.out.println(xpath);
            //WaitForPageLoadedAndElementLocated(By.xpath(xpath));
            WaitForPageLoaded();
            List<WebElement> elementsDivList = element.findElements(By.xpath(xpath));
            return elementsDivList;
        } catch (Exception e) {
            return null;
        }

    }
}
