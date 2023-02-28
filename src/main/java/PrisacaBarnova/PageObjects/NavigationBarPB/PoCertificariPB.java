package PrisacaBarnova.PageObjects.NavigationBarPB;

import PrisacaBarnova.PageObjects.PoBasePagePB;
import org.openqa.selenium.By;

public class PoCertificariPB extends PoBasePagePB {

    private By firstCertificate = By.cssSelector("img[title='8']");
    private By displayedFirstCertificate = By.cssSelector("span[class='bwg_popup_image_spun2'] img[alt='8']");

    public void clickCertificate() {
        click(firstCertificate);
    }
    public void displayCertificate(){
    driver.findElement(displayedFirstCertificate).isDisplayed();
    }
}
