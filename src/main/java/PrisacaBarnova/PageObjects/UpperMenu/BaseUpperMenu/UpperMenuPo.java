package PrisacaBarnova.PageObjects.UpperMenu.BaseUpperMenu;

import PrisacaBarnova.PageObjects.BasePoPagePB;
import PrisacaBarnova.PageObjects.UpperMenu.PoCheckoutPB;
import PrisacaBarnova.PageObjects.UpperMenu.PoContulMeuPB;
import PrisacaBarnova.PageObjects.UpperMenu.PoCosPB;
import PrisacaBarnova.PageObjects.UpperMenu.HomePBPo;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class UpperMenuPo extends BasePoPagePB {

    private By menuHomeButton = By.cssSelector("a[title='Home']");
    private By menuCosButton = By.cssSelector("a[title='Cos']");
    private By menuCheckoutButton = By.cssSelector("a[title='Checkout']");
    private By menuContulmeuButton = By.cssSelector("a[title='Contul meu']");

    public HomePBPo menuHomePB(){
        click(menuHomeButton);
        System.out.println("Opened page:" + getPageTitle());
        return new HomePBPo();
    }
    public PoCosPB menuCosPB(){
        click(menuCosButton);
        System.out.println("Opened page:" + getPageTitle());
        log.info("Opened page:" + getPageTitle());
        return new PoCosPB();
    }
    public PoCheckoutPB checkoutPB(){
        click(menuCheckoutButton);
        System.out.println("Opened page:" + getPageTitle());
        return new PoCheckoutPB();
    }
    public PoContulMeuPB contulMeuPB(){
        click(menuContulmeuButton);
        log.info("Opened page:" + getPageTitle());
        String pageTitle = getPageTitle();
        assertEquals(pageTitle, "Contul meu - Prisaca Barnova");
        return new PoContulMeuPB();
    }
}
