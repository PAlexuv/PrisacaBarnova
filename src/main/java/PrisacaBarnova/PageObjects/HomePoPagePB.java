package PrisacaBarnova.PageObjects;

import org.openqa.selenium.By;

public class HomePoPagePB extends BasePoPagePB {
    private By logo =  By.cssSelector(".logo");

    public String getTitle() {
        return getPageTitle();
    }

    public void logoIsHere() {
        driver.findElement(logo).isDisplayed();
    }
}
