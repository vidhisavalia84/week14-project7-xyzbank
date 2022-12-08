package com.bank.pages;

import com.bank.utility.Utility;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;

public class AccountPage extends Utility {
  /*  customerShouldDepositMoneySuccessfully.
    click on "Customer Login" Tab
    search customer that you created.
    click on "Login" Button
    click on "Deposit" Tab
    Enter amount 100
    click on "Deposit" Button
    verify message "Deposit Successful"*/

    By deposit = By.xpath("//button[@ng-click='deposit()']");

    public void clickOnDepositButton() {
        clickOnElement(deposit);
    }

    By depositAmount = By.xpath("//input[@placeholder='amount']");

    public void enterAmountIntoDepositFeild(String num) {
        sendTextToElement(depositAmount, num);
    }

    By finalDeposit = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]");

    public void clickOnDepositButtonAfterEnterAmount() {
        clickOnElement(finalDeposit);
    }
    By depositSuccessfulMessage=By.xpath("//span[contains(text(),'Deposit Successful')]");
    public String verifyDepositSuccessfulMessage(){
        return getTextFromElement(depositSuccessfulMessage);
    }


    /*customerShouldWithdrawMoneySuccessfully
    click on "Customer Login" Tab
    search customer that you created.
    click on "Login" Button
    click on "Withdrawl" Tab
    Enter amount 50
    click on "Withdraw" Button
    verify message "Transaction Successful"*/

    By withdrawlButton=By.xpath("//button[@ng-click='withdrawl()']");

public void clickOnWithdrawlButton(){
    clickOnElement(withdrawlButton);
}
By amountWithdrawlField=By.xpath("//input[@placeholder='amount']");
public void enterAmountYouWishToWithdrawl(String amount){
    sendTextToElement(amountWithdrawlField,amount);
}
By withdrawButton1=By.xpath("//button[contains(text(),'Withdraw')and@type='submit']");
public void clickOnWithdrawlButtonAfterEnterAmount(){
    clickOnElement(withdrawButton1);
}
By transactionMessage=By.xpath("//span[contains(text(),'Transaction successful')]");
public String verifyTransactionSuccessfulMessage(){
    return getTextFromElement(transactionMessage);
}



}
