package testPrisacaBarnova.testUpperMenu;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testPrisacaBarnova.BaseTestsPB;

public class testHomeButton extends BaseTestsPB {

    @BeforeClass(alwaysRun = true)
    public void clickHomeButton(){
        upperMenuPB.menuHomePB();
    }

    @Test(description = "test menu homepage button")
    public void testHomeButton(){
        String pagetitle = homePB.getHomeTitle();
        Assert.assertEquals(pagetitle, "Prisaca Barnova - Miere Naturala de Albine");
        String menuHomeButtonText = homePB.getMenuHomeButtonText();
        Assert.assertEquals(menuHomeButtonText, "Homee");
    }
}
