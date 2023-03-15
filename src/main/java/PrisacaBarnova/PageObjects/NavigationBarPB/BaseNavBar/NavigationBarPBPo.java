package PrisacaBarnova.PageObjects.NavigationBarPB.BaseNavBar;

import PrisacaBarnova.PageObjects.NavigationBarPB.*;
import PrisacaBarnova.PageObjects.BasePoPagePB;
import org.openqa.selenium.By;

public class NavigationBarPBPo extends BasePoPagePB {
    private By produseButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Produse']");
    private By stupinaButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Stupina']");
    private By certificariButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Certificari']");
    private By despreNoiButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Despre noi']");
    private By articoleButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Articole']");
    private By contactButton = By.cssSelector("ul[id='menu-main-menu-1'] a[title='Contact']");
    private By searchBarNavBar = By.cssSelector("#s");
    private By homeIconButton = By.cssSelector(".homebutton");

    public PoHomeIconPB homeIcon(){
        click(homeIconButton);
        System.out.println("Opened page: " + getPageTitle());
        return new PoHomeIconPB();
    }

    public PoProdusePB produsePB() {
        click(produseButton);
        return new PoProdusePB();
    }

    public PoStupinaPB stupinaPB() {
        click(stupinaButton);
        return new PoStupinaPB();
    }

    public CertificariPBPo certificariPB() {
        click(certificariButton);
        System.out.println("Opened page: " + getPageTitle());
        return new CertificariPBPo();
    }

    public PoDespreNoiPB despreNoiPB() {
        click(despreNoiButton);
        return new PoDespreNoiPB();
    }

    public PoArticolePB articolePB() {
        click(articoleButton);
        System.out.println("Opened page: " + getPageTitle());
        return new PoArticolePB();
    }

    public PoContactPB contactPB() {
        click(contactButton);
        return new PoContactPB();
    }

    public PoSearchNavBarPB searchNavBarPB() {
        click(searchBarNavBar);
        return new PoSearchNavBarPB();
    }
}
