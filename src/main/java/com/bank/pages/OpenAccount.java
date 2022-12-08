package com.bank.pages;

import com.bank.utility.Utility;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;

public class OpenAccount extends Utility {
   /* click On "Bank Manager Login" Tab
    click On "Open Account" Tab
    Search customer that created in first test
    Select currency "Pound"
    click on "process" button
    popup displayed
    verify message "Account created successfully"
    click on "ok" button on popup.*/
By openAccount=By.xpath("//button[@ng-click='openAccount()']");

public void clickOnOpenAccount(){
    clickOnElement(openAccount);
}
By customerNameDropdown=By.id("userSelect");
public void clickCustomerFromDropDown(){

    //selectOptionByIndex(customerNameDropdown,6);
    selectOptionsByContainText(customerNameDropdown,"Krish Patel");
}
By currency=By.id("currency");
public void selectCurrencyPoundFromDropDown(){
    selectOptionsByValue(currency,"Pound");
}
By process=By.xpath("//button[@type='submit']");
public void clickOnProcessButton(){
    clickOnElement(process);
}
//Account created successfully with account Number :1016
    public String getSuccessfulTextFromPopup(){
    //String[] arr = new String[2];

        return getTextFormAlert();
    }

public void clickOkOnPopup(){
    acceptAlert();
}















}
