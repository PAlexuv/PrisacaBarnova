package PrisacaBarnova.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class PoBasePagePB {

    protected static WebDriver driver;

    public String browser;
    public String baseUrl;
    public Properties properties;

    public void loadProperties(){
        FileInputStream fis = null;

        try{
            properties = new Properties();
            fis = new FileInputStream("C:\\Automation\\IntelliJProjects\\PrisacaBarnova\\src\\main\\java\\PrisacaBarnova\\Config\\config.properties");
            properties.load(fis);
            browser = properties.getProperty("browserPB");
            baseUrl = properties.getProperty("baseUrlPB");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openBrowser(){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    public void closeBrowser(){
        driver.quit();
    }
    public void closePage(){
        driver.close();
    }

    public boolean goToHomepagePB(){
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
        }catch (Exception e){
            System.out.println("Unable to navigate to homepage!!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForElementText(By locator, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void hoverOverElement(By locator){
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void scrollElementIntoView(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getTextByValue(By locator){
        return driver.findElement(locator).getAttribute("value");
    }
    public String getTextByText(By locator){
        return driver.findElement(locator).getText();
    }

    public void setText(By locator, String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        tab(locator);
    }
    public void tab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void goBack(){
        driver.navigate().back();
    }
    //Window handles
    public String getWindowHandle(){
        return driver.getWindowHandle();
    }
    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }
    public int getNumberOfOpenWindows(){
        return driver.getWindowHandles().size();
    }

    //open new tab JavascriptExecutor
    public void openNewTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public void dragAndDropByOffset(By locator, int x, int y){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.dragAndDropBy(element, x, y).perform();
    }

    public void acceptCookies(By locator){
        click(locator);
    }

}
