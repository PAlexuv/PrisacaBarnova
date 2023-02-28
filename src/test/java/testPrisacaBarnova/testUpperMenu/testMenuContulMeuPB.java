package testPrisacaBarnova.testUpperMenu;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testPrisacaBarnova.BasePageTestsPB;

public class testMenuContulMeuPB extends BasePageTestsPB {

    @BeforeClass(alwaysRun = true)
    public void openContulMeu(){
    upperMenuPB.contulMeuPB();
    }

    @Test(description = "authenticate with false credentials")
    public void testAuthenticate() {
        String userError = "userTest";
        String passError = "eroareParola";
        menuContulMeuPB.contulMeu(userError, passError);
//        Thread.sleep(2000);
        String errorMessageAuth = menuContulMeuPB.getAuthenticateError();
        Assert.assertEquals(errorMessageAuth,"Eroare: numele de utilizator " + userError + " nu este înregistrat pe acest site. Dacă nu îți amintești numele de utilizator, încearcă folosind adresa de email.");
    }
}
