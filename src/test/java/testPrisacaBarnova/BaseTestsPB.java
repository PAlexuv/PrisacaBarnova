package testPrisacaBarnova;

import PrisacaBarnova.PageObjects.NavigationBarPB.*;
import PrisacaBarnova.PageObjects.NavigationBarPB.BaseNavBar.NavigationBarPBPo;
import PrisacaBarnova.PageObjects.BasePoPagePB;
import PrisacaBarnova.PageObjects.HomePoPagePB;
import static org.testng.Assert.*;

import PrisacaBarnova.PageObjects.UpperMenu.*;
import PrisacaBarnova.PageObjects.UpperMenu.BaseUpperMenu.UpperMenuPo;
import Utils.TestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public class BaseTestsPB extends BasePoPagePB {

    protected HomePoPagePB homePagePB;
    //upper menu
    protected UpperMenuPo upperMenuPB;
    protected HomePBPo homePB;
    protected PoCosPB cosPB;
    protected PoCheckoutPB checkoutPB;
    protected PoContulMeuPB contulMeuPB;
    //navigation bar
    protected NavigationBarPBPo navBarPB;
    protected PoProdusePB produsePB;
    protected PoStupinaPB stupinaPB;
    protected CertificariPBPo certificariPB;
    protected PoDespreNoiPB despreNoiPB;
    protected PoArticolePB articolePB;
    protected PoContactPB contactPB;
    protected PoSearchNavBarPB searchNavBarPB;
    protected PoHomeIconPB homeIconPB;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        assertTrue(goToHomepagePB(),"An error occured while navigating to homepage!!");
        //instantiate upper menu
        upperMenuPB = new UpperMenuPo();
        homePB = new HomePBPo();
        cosPB = new PoCosPB();
        checkoutPB = new PoCheckoutPB();
        contulMeuPB = new PoContulMeuPB();
        homeIconPB = new PoHomeIconPB();
        //instantiate navBar
        navBarPB = new NavigationBarPBPo();
        homePagePB = new HomePoPagePB();
        produsePB = new PoProdusePB();
        stupinaPB = new PoStupinaPB();
        certificariPB = new CertificariPBPo();
        despreNoiPB = new PoDespreNoiPB();
        articolePB = new PoArticolePB();
        contactPB = new PoContactPB();
        searchNavBarPB = new PoSearchNavBarPB();
    }

//    @AfterMethod(alwaysRun = true)
//    public void failedScreenshot(ITestResult result){
//        if(result.getStatus() == ITestResult.FAILURE){
//            String testName = result.getMethod().getMethodName();
//            System.out.println("Failed Test! Take screenshot: " + testName);
//            takeScreenshot(testName);
//        }
//    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }

}
