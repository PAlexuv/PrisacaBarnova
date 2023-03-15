package testPrisacaBarnova;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testHomePB extends BaseTestsPB {

    @Test
    public void testPageTitle(){
        String pageTitle = homePagePB.getTitle();
        Assert.assertEquals(pageTitle, "Prisaca Barnova - Miere Naturala de Albine");
    }
    @Test
    public void testPresenceOfLogo(){
        homePagePB.logoIsHere();
    }

}
