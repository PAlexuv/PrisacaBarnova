package PrisacaBarnova.PageObjects.UpperMenu;

import PrisacaBarnova.PageObjects.BasePoPagePB;
import org.openqa.selenium.By;

public class HomePBPo extends BasePoPagePB {

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
