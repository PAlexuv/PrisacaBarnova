package testPrisacaBarnova.testNavBarPB;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testPrisacaBarnova.BasePageTestsPB;

public class testCertificariPB extends BasePageTestsPB {

    @BeforeClass(alwaysRun = true)
    public void openCertificatePage(){
        navBarPB.certificariPB();
    }

    @Test(description = "open certificate")
    public void openCertificate(){
        certificariPB.clickCertificate();
//        certificariPB.displayCertificate();
    }

}
