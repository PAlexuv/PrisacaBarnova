package PrisacaBarnova.PageObjects.NavigationBarPB;

import PrisacaBarnova.PageObjects.PoBasePagePB;
import org.openqa.selenium.By;

public class PoNavigationBarPB extends PoBasePagePB {
    private By produseButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Produse']");
    private By stupinaButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Stupina']");
    private By certificariButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Certificari']");
    private By despreNoiButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Despre noi']");
    private By articoleButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Articole']");
    private By contactButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Contact']");
    private By searchBarNavBar = By.cssSelector("#s");

    public PoArticolePB articolePB(){
        click(articoleButton);
        System.out.println("Opened page: " + getPageTitle());
        return new PoArticolePB();
    }
    public PoCertificariPB certificariPB(){
        click(certificariButton);
        System.out.println("Opened page: " + getPageTitle());
        return new PoCertificariPB();
    }
}
