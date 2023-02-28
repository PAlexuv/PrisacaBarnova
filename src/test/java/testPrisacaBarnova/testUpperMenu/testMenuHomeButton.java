package testPrisacaBarnova.testUpperMenu;

import org.testng.Assert;
import org.testng.annotations.Test;
import testPrisacaBarnova.BasePageTestsPB;

public class testMenuHomeButton extends BasePageTestsPB {

    @Test(description = "test menu homepage button")
    public void testHomeButton(){
        String pagetitle = menuHomePB.getHomeTitle();
        Assert.assertEquals(pagetitle, "Prisaca Barnova - Miere Naturala de Albine");
        String menuHomeButtonText = menuHomePB.getMenuHomeButtonText();
        Assert.assertEquals(menuHomeButtonText, "Home");
    }
}
