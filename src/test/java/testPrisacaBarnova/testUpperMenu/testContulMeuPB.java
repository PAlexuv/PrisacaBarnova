package testPrisacaBarnova.testUpperMenu;

import Utils.DataUtilsDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testPrisacaBarnova.BaseTestsPB;

import java.util.HashMap;

import static org.junit.Assert.*;

public class testContulMeuPB extends BaseTestsPB {

    @BeforeClass(alwaysRun = true)
    public void openContulMeu() {
        upperMenuPB.contulMeuPB();
        contulMeuPB.acceptedCookie();
    }

    @Test(description = "authenticate with false credentials")
    public void testAuthenticate() {
        String userError = "userTest";
        String passError = "eroareParola";
        contulMeuPB.contulMeu(userError, passError);
//        Thread.sleep(2000);
        String errorMessageAuth = contulMeuPB.getAuthenticateError();
        Assert.assertEquals(errorMessageAuth, "Eroare: numele de utilizator " + userError + " nu este înregistrat pe acest site. Dacă nu îți amintești numele de utilizator, încearcă folosind adresa de email.");
    }

//    @Test(description = "authenticate with JSON data", dataProviderClass = DataUtilsDataProvider.class, dataProvider = "dataProvider2")
//    public void testAuthJson(HashMap<String, String> hashMap) {
//        contulMeuPB.setUsername(hashMap.get("UserField"))
//                .setPassword(hashMap.get("PasswordField"))
//                .selectCheckbox(hashMap.get("RememberMeCheckbox"))
//                .clickAuthenticate();
//
//    }
    @Test(description = "Authenticate with Json - 2 Sets of Data", dataProviderClass = DataUtilsDataProvider.class, dataProvider = "dataProvider1")
    public void testAuthJson2(String data){

        String[] authInfo = data.split(",");

        contulMeuPB
                .setUsername(authInfo[0])
                .setPassword(authInfo[1])
                .selectCheckbox(authInfo[2])
                .clickAuthenticate();

        String errorMsg = contulMeuPB.getAuthenticateError();
        assertTrue(errorMsg.contains("Eroare"));

    }
}
