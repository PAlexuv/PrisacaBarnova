package testPrisacaBarnova;

import PrisacaBarnova.PageObjects.NavigationBarPB.*;
import PrisacaBarnova.PageObjects.PoBasePagePB;
import PrisacaBarnova.PageObjects.PoHomePagePB;
import static org.testng.Assert.*;

import PrisacaBarnova.PageObjects.UpperMenu.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class BasePageTestsPB extends PoBasePagePB {

    protected PoHomePagePB homePagePB;
    //navigation bar
    protected PoNavigationBarPB navBarPB;
    protected PoProdusePB produsePB;
    protected PoStupinaPB stupinaPB;
    protected PoCertificariPB certificariPB;
    protected PoDespreNoiPB despreNoiPB;
    protected PoArticolePB articolePB;
    protected PoContactPB contactPB;
    protected PoSearchNavBarPB searchNavBarPB;

    //upper menu
    protected PoUpperMenu upperMenuPB;
    protected PoHomePB menuHomePB;
    protected PoCosPB menuCosPB;
    protected PoCheckoutPB menuCheckoutPB;
    protected PoContulMeuPB menuContulMeuPB;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        assertTrue(goToHomepagePB(),"An error occured while navigating to homepage!!");
        //instantiate navBar
        navBarPB = new PoNavigationBarPB();
        homePagePB = new PoHomePagePB();
        produsePB = new PoProdusePB();
        stupinaPB = new PoStupinaPB();
        certificariPB = new PoCertificariPB();
        despreNoiPB = new PoDespreNoiPB();
        articolePB = new PoArticolePB();
        contactPB = new PoContactPB();
        searchNavBarPB = new PoSearchNavBarPB();
        //instantiate upper menu
        upperMenuPB = new PoUpperMenu();
        menuHomePB = new PoHomePB();
        menuCosPB = new PoCosPB();
        menuCheckoutPB = new PoCheckoutPB();
        menuContulMeuPB = new PoContulMeuPB();

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }

}
