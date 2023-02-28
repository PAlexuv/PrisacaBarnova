package PrisacaBarnova.PageObjects.UpperMenu;

import PrisacaBarnova.PageObjects.PoBasePagePB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PoHomePB extends PoBasePagePB {

    private By menuHomeButton = By.cssSelector("a[title='Home']");

    public String getHomeTitle(){
        System.out.println(getPageTitle());
        return getPageTitle();
    }
    public String getMenuHomeButtonText(){
        System.out.println(getTextByText(menuHomeButton));
        return getTextByText(menuHomeButton);
    }


}
