package testPrisacaBarnova.testNavBarPB;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testPrisacaBarnova.BaseTestsPB;

public class testCertificariPB extends BaseTestsPB {

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
