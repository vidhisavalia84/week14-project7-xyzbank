package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility {
    /* click On "Bank Manager Login" Tab
        click On "Add Customer" Tab
        enter FirstName
        enter LastName
        enter PostCode
        click On "Add Customer" Button
        popup display
        verify message "Customer added successfully"
        click on "ok" button on popup.*/
    By addCustomer = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]");

    By firstName = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");

    By lastName = By.xpath("//input[@placeholder='Last Name']");

    By postCode = By.xpath("//input[@placeholder='Post Code']");

    By addCustomer1 = By.xpath("//button[text()='Add Customer']");

        public void clickOnAddCustomerButton () {
        clickOnElement(addCustomer);
    }
    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }

    public void enterLastName(String name) {
        sendTextToElement(lastName, name);
    }

public void enterPostCode(String code){
        sendTextToElement(postCode,code);
}

public void clickOnAddCustomerButtonAfterEnterInformation(){
        clickOnElement(addCustomer1);
}
//Customer added successfully with customer id :6

public String verifyReceivedTextFromPopup(){
        return getTextFormAlert();
}
public void clickOkOnPopup(){
        acceptAlert();
}




}
