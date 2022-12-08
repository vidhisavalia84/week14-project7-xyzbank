package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManager = new BankManagerLoginPage();
    CustomerLoginPage customerPage = new CustomerLoginPage();
    OpenAccount openAccount = new OpenAccount();
    AccountPage accountPage = new AccountPage();

    @Test
    public void sampleTest() {
        System.out.println("passed");
    }

    @Test//1
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManager.clickOnAddCustomerButton();
        Thread.sleep(2000);
        bankManager.enterFirstName("Krish");
        bankManager.enterLastName("Patel");
        bankManager.enterPostCode("Ha3 8LU");
        bankManager.clickOnAddCustomerButtonAfterEnterInformation();
        Assert.assertEquals(bankManager.verifyReceivedTextFromPopup(), "Customer added successfully with customer id :6");
         bankManager.clickOkOnPopup();
    }

    @Test//2
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManager.clickOnAddCustomerButton();
        Thread.sleep(2000);
        bankManager.enterFirstName("Krish");
        bankManager.enterLastName("Patel");
        bankManager.enterPostCode("Ha3 8LU");
        bankManager.clickOnAddCustomerButtonAfterEnterInformation();
        bankManager.clickOkOnPopup();
        /****************************************************************/
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginButton();
        openAccount.clickOnOpenAccount();
        openAccount.clickCustomerFromDropDown();
        openAccount.selectCurrencyPoundFromDropDown();
        openAccount.clickOnProcessButton();
        Assert.assertEquals(openAccount.getSuccessfulTextFromPopup(), "Account created successfully with account Number :1016");
        openAccount.clickOkOnPopup();

    }

    @Test//3
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManager.clickOnAddCustomerButton();
        Thread.sleep(2000);
        bankManager.enterFirstName("Krish");
        bankManager.enterLastName("Patel");
        bankManager.enterPostCode("Ha3 8LU");
        bankManager.clickOnAddCustomerButtonAfterEnterInformation();
        bankManager.clickOkOnPopup();
        /**************************************************/
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginButton();
        customerPage.selectYourNameFromDropDown();
        customerPage.clickOnLoginButton();
        Assert.assertEquals(customerPage.verifyLogOutText(), "Logout");
        customerPage.cliclOnLogoutButton();
        Assert.assertEquals(customerPage.verifyYourNameText(), "Your Name :");
    }

    @Test//4
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManager.clickOnAddCustomerButton();
        Thread.sleep(2000);
        bankManager.enterFirstName("Krish");
        bankManager.enterLastName("Patel");
        bankManager.enterPostCode("Ha3 8LU");
        bankManager.clickOnAddCustomerButtonAfterEnterInformation();
        bankManager.clickOkOnPopup();
        homePage.clickOnHomeButton();
        /**************************************************/
        homePage.clickOnCustomerLoginButton();
       customerPage.selectHarryPotterFromDropDown();
        //customerPage.selectYourNameFromDropDown();
        customerPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountIntoDepositFeild("100");
        accountPage.clickOnDepositButtonAfterEnterAmount();
        Assert.assertEquals(accountPage.verifyDepositSuccessfulMessage(),"Deposit Successful");
    }
    @Test
    public void customerShouldWithdrawMoneySuccessfully(){


        homePage.clickOnCustomerLoginButton();
       // customerPage.selectYourNameFromDropDown();
        customerPage.selectHarryPotterFromDropDown();
        customerPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountIntoDepositFeild("100");
        accountPage.clickOnDepositButtonAfterEnterAmount();
                homePage.clickOnHomeButton();

        /*****************************************************/
        homePage.clickOnCustomerLoginButton();
        //customerPage.selectYourNameFromDropDown();
        customerPage.selectHarryPotterFromDropDown();
        customerPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlButton();
        accountPage.enterAmountYouWishToWithdrawl("10");
        accountPage.clickOnWithdrawlButtonAfterEnterAmount();
        Assert.assertEquals(accountPage.verifyTransactionSuccessfulMessage(),"Transaction successful","transaction unsuccessful");


    }
}
