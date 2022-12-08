package com.bank.utility;

import com.bank.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Utility extends ManageBrowser {

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();


    }

    public void sendTextToElement(By by, String text) {
        WebElement emailField = driver.findElement(by);
        //type the email add for email feild
        emailField.sendKeys(text);
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
    //*********************************   Alert methods ******************************

    /**
     * This method will switch to alert
     */

    public void switchToAlert() {
        driver.switchTo().alert();

    }

    /*Accept alert/* This method will switch to alert*/
    public void acceptAlert() {

        driver.switchTo().alert().accept();
    }

    /* dismis alert.This method will dismiss alert*/
    public void dismisAlert() {
        driver.switchTo().alert().dismiss();//Void dismiss(): This method is used when the ‘Cancel’ button is clicked in the alert bo
    }

    /*Get text from alert/* This method will get text from alert*/
    public String getTextFormAlert() {
        return driver.switchTo().alert().getText();// String getText(): This method is used to capture the alert message.
    }

    //Send text to alert/*This method will send text from alert*/
    public void sendTextToAlert(String text) {
        // Void sendKeys(String stringToSend): This method is used to send data to the alert box.
        driver.switchTo().alert().sendKeys(text);
    }


//************************************  select class Methods****************************************************************

    /**
     * This method will select option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);

        select.selectByValue(text);//select by value
    }

    /**
     * This method will select the option by value
     */
    public void selectOptionsByValue(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);

    }

    /**
     * This method will select the option by index
     */
    public void selectOptionByIndex(By by, int index) {
      /*  WebElement option = driver.findElement(by);
        Select select = new Select(option);
        select.selectByIndex(index);*/
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */

    public void selectOptionsByContainText(By by, String text) {

        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();

            }
        }

    }

    //*************************** Action Methods ***************************************//
    /* This method will use to hover mouse on element*/
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        // WebElement computer = driver.findElement(by);
        //actions.moveToElement(computer).build().perform();
    }

    //This method will use to  mouse hover on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        // WebElement software = driver.findElement(by);
        //actions.moveToElement(software).click().build().perform();
    }

    public void dragAndDrop(By by, By by1) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(by), driver.findElement(by1)).build().perform();
        //WebElement draggable = driver.findElement(By.id("draggable"));
        //WebElement droppable = driver.findElement(By.id("droppable"));
        //actions.dragAndDrop(draggable, droppable).build().perform();
    }

    //********************* This method will clear text  *************************//
    public void clearText(By by) {
        Actions actions = new Actions(driver);
        WebElement quantity = driver.findElement(by);
        quantity.clear();
    }

    /**********************verify message*********************/
    //This method will verify the messages and will retyrn pass or fail
   /* public void verifyMessage(String expectedMessage, String actualMessage) {
        Assert.assertEquals(expectedMessage, actualMessage);

    }

//*************************** Window Handle Methods ***************************************/


    /* This method will close all windows*/

    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }


    /* This method will switch to parent window*/

    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;

    }
    //************************** Waits Methods *********************************************//


    /******** This method will use to wait until  VisibilityOfElementLocated   **************/
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;

    }
    public static String getAlphaNumericString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

}
