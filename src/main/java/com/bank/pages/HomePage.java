package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By bankManagerLogin = By.xpath("//button[text()='Bank Manager Login']");
    By customerLogin = By.xpath("//button[text()='Customer Login']");
    By yourNameText = By.xpath("//label[text()='Your Name :']");

    public void clickOnCustomerLoginButton() {
        clickOnElement(customerLogin);
    }


    public String verifyYourNameText() {
        return getTextFromElement(yourNameText);
    }
public void clickOnBankManagerLoginButton(){
        clickOnElement(bankManagerLogin);
}
By homeButton=By.xpath("//button[contains(text(),'Home')]");
    public void clickOnHomeButton(){
        clickOnElement(homeButton);
    }


}
