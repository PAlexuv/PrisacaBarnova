package PrisacaBarnova.PageObjects.UpperMenu;

import PrisacaBarnova.PageObjects.PoBasePagePB;
import org.openqa.selenium.By;

public class PoUpperMenu extends PoBasePagePB {

    private By menuHomeButton = By.cssSelector("a[title='Home']");
    private By menuCosButton = By.cssSelector("a[title='Cos']");
    private By menuCheckoutButton = By.cssSelector("a[title='Checkout']");
    private By menuContulmeuButton = By.cssSelector("a[title='Contul meu']");

    public PoHomePB menuHomePB(){
        click(menuHomeButton);
        System.out.println("Opened page:" + getPageTitle());
        return new PoHomePB();
    }
    public PoCosPB menuCosPB(){
        click(menuCosButton);
        System.out.println("Opened page:" + getPageTitle());
        return new PoCosPB();
    }
    public PoCheckoutPB checkoutPB(){
        click(menuCheckoutButton);
        System.out.println("Opened page:" + getPageTitle());
        return new PoCheckoutPB();
    }
    public PoContulMeuPB contulMeuPB(){
        click(menuContulmeuButton);
        System.out.println("Opened page:" + getPageTitle());
        return new PoContulMeuPB();
    }
}
