package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {
/*3. customerShouldLoginAndLogoutSuceessfully.
	click on "Customer Login" Tab
	search customer that you created.
	click on "Login" Button
	verify "Logout" Tab displayed.
	click on "Logout"
	verify "Your Name" text displayed.*/

By yourName=By.id("userSelect");
public void selectYourNameFromDropDown(){
    selectOptionsByContainText(yourName,"Krish Patel");
}
public void selectHarryPotterFromDropDown(){
    selectOptionsByContainText(yourName,"Harry Potter");
}
By login=By.xpath("//button[@type='submit']");
public void clickOnLoginButton(){
    clickOnElement(login);
}
By logout=By.xpath("//button[@class='btn logout']");

public String verifyLogOutText(){

    return getTextFromElement(logout);
}
public void cliclOnLogoutButton(){
    clickOnElement(logout);
}
By yourNameMessage=By.xpath("//label[contains(text(),'Your Name :')]");
public String verifyYourNameText(){
    return getTextFromElement(yourNameMessage);
}

}
