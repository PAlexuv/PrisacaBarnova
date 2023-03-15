package PrisacaBarnova.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

public class BasePoPagePB {

    protected static WebDriver driver;
    protected static Logger log = LogManager.getLogger();

    public String browser;
    public String baseUrl;
    public Properties properties;
    public static final String SCREENSHOT_PATH = "C:\\Automation\\IntelliJProjects\\PrisacaBarnova\\SeleniumScreenshots";
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public void loadProperties() {
        FileInputStream fis = null;

        try {
            properties = new Properties();
            fis = new FileInputStream("C:\\Automation\\IntelliJProjects\\PrisacaBarnova\\src\\main\\java\\PrisacaBarnova\\Config\\config.properties");
            properties.load(fis);
            browser = properties.getProperty("browserPB");
            baseUrl = properties.getProperty("baseUrlPB");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void openBrowser() {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            //WebDriverManager.chromedriver().driverVersion("xx.xx.xx.xx").setup();
            //Disable message 'Chrome is being controlled by automated test software'
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// IMPLICIT WAIT!!!
        driver.manage().window().maximize();
    }

    public boolean goToHomepagePB() {
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
        } catch (Exception e) {
            System.out.println("Unable to navigate to homepage!!");

            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void acceptCookies(By locator) {
        click(locator);
    }

    public void setCookie(String name, String value){
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }
    public Cookie getCookie(String name){
        return  driver.manage().getCookieNamed(name);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void closePage() {
        driver.close();
    }

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void waitForElementTextFluentWait(By locator, String text) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))//wait for 3 seconds for the element text to appear
                .pollingEvery(Duration.ofSeconds(1))//check every 1 second in the 3 seconds interval if the element text appeared
                .ignoring(NoSuchElementException.class);//type of exceptions that we want to ignore
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void scrollElementIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollPage(int x, int y){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollby(" + x + "," + y + ")");//no need for an element as we do not look for an element, just scroll page
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getTextByValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public String getTextByText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void setText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        tab(locator);
    }

    public void tab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void goBack() {
        driver.navigate().back();
    }

    //Window handles
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public int getNumberOfOpenWindows() {
        return driver.getWindowHandles().size();
    }

    //open new tab JavascriptExecutor
    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void dragAndDropByOffset(By locator, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.dragAndDropBy(element, x, y).perform();
    }

    public void dismissPopUp(){
        driver.switchTo().alert().dismiss();
    }
    public void acceptPopUp(){
        driver.switchTo().alert().accept();
    }
    public void setPopupText(String popupText){
        driver.switchTo().alert().sendKeys(popupText);
    }

    //****************************** TAKE SCREENSOTS *********************************

    public void takeScreenshotNamed(String testName){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        LocalDateTime currentTime = LocalDateTime.now();
        String dateTimeFormat = currentTime.format(dateTimeFormatter).split("\\.")[0].replaceAll(":", "-");
        String screenshotName = SCREENSHOT_PATH +"\\Screenshot-" + testName + "-" + dateTimeFormat + ".jpeg";

        File savedScreenshot = new File(screenshotName);

        try {
            FileUtils.copyFile(file, savedScreenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        LocalDateTime currentTime = LocalDateTime.now();
        String dateTimeFormat = currentTime.format(dateTimeFormatter).split("\\.")[0].replaceAll(":", "-");
        String screenshotName = SCREENSHOT_PATH +"\\screenshot-" + dateTimeFormat + ".jpeg";//we need SCREENSHOT_PATH as new file path require it

        File savedScreenshot = new File(screenshotName);

        try {
            FileUtils.copyFile(file, savedScreenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Take screenshot...");
    }
    public void takeElementScreenshot(By locator){
        WebElement element = driver.findElement(locator);//create webelement
        File file = element.getScreenshotAs(OutputType.FILE);//set the screenshot file for the webelement to be screenshotted

        LocalDateTime currentTime = LocalDateTime.now();//set current date... and format for better understanding
        String dateTimeFormat = currentTime.format(dateTimeFormatter).split("\\.")[0].replaceAll(":", "");
        //create the screenshot text: where to send the screenshot, set the text for the file, set it to jpeg not .png(default)
        String screenshotName = SCREENSHOT_PATH + "\\screenshot-" + element.getText() + "-" + dateTimeFormat + ".jpeg";

        File savedScreenshot = new File(screenshotName);//input into File the screenshotName which contains the Webelement that we just set-up

        try {
            //call FileUtils wich has 2 params: SOURCE FILE (the webelement), DESTINATION FILE(contains PATH + the name we set up to understand it better
            FileUtils.copyFile(file, savedScreenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchFramesIndex(int frame){
        driver.switchTo().frame(frame);
    }
    public void switchToDefaultFrame(){
        driver.switchTo().defaultContent();
    }

}
