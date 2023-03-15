package PrisacaBarnova.PageObjects.UpperMenu;

import PrisacaBarnova.PageObjects.BasePoPagePB;
import org.openqa.selenium.By;

public class PoContulMeuPB extends BasePoPagePB {

    private By userField = By.cssSelector("#username");
    private By passwordField = By.cssSelector("#password");
    private By checkBoxAuthenticate = By.xpath("//span[text()='Ține-mă minte']");
    private By authenticateButton = By.cssSelector("button[value='Autentificare']");
    private By acceptCookie = By.cssSelector("#cookie_action_close_header_reject");

    private By authError = By.xpath("//li[contains(.,'Eroare: numele de utilizator')]");

    public PoContulMeuPB contulMeu(String userText, String passText){
        acceptCookies(acceptCookie);
        setText(userField,userText);
        setText(passwordField, passText);
        click(checkBoxAuthenticate);
        click(authenticateButton);
        waitForElement(authError);
        return this;
    }
    public String getAuthenticateError(){
        System.out.println(getTextByText(authError));
        return getTextByText(authError);
    }

    public PoContulMeuPB acceptedCookie(){
        waitForElement(acceptCookie);
        acceptCookies(acceptCookie);
        return this;
    }

    //methods for JSON - use database - testData
    public PoContulMeuPB setUsername(String userText) {
        setText(userField,userText);
        return this;
    }
    public PoContulMeuPB setPassword(String passwordText) {
        setText(passwordField,passwordText);
        return this;
    }
    public PoContulMeuPB selectCheckbox(String checkboxText) {
//        scrollElementIntoView(authenticateButton);
        getTextByValue(checkBoxAuthenticate);
        driver.findElement(By.xpath("//span[text()='"+checkboxText+"']")).click();
        return this;
    }
    public void clickAuthenticate() {
        click(authenticateButton);
    }


}
