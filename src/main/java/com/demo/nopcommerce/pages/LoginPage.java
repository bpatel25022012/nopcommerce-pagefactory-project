package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/*
Created By Bhavesh
*/
public class LoginPage extends Utility {
    HomePage homePage = new HomePage();
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    @FindBy(id="Email")
    WebElement emailField;
    @FindBy(id="Password")
    WebElement passwordField;
    @FindBy (xpath = "//input[@class='button-1 login-button']")
    WebElement loginBtn;
    @FindBy (xpath = "//div[@class='page-title']//h1")
    WebElement welcomeText;
    @FindBy (xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement loginPageText;

    public void waitUntilVisibility(){

        waitUntilPresenceOfElementLocated(emailField,20);
    }

    public void enterEmailId(String email) {
        Reporter.log("Entering email address : " + email +" "+ " to email field : " + emailField.toString() + "<br>");
        sendTextToElement(emailField, email);
        log.info("Entering email address "+ email +" "+ "to email field : " + emailField.toString());
    }

    public void enterPassword(String password) {
        Reporter.log("Entering password : " + password +" "+ " to password field : " + passwordField.toString() + "<br>");
        sendTextToElement(passwordField, password);
        log.info("Entering password : "+ password +" "+ " to password field :" + passwordField.toString());
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking on login button : " + loginBtn.toString() + "<br>");
        clickOnElement(loginBtn);
        log.info("Clicking on login Button"+loginBtn.toString());
    }

    public String getWelcomeText() {
        Reporter.log("Getting text from : " + welcomeText.toString() + "<br>");
        log.info("Getting text from " +welcomeText.toString());
        return getTextFromElement(welcomeText);
    }



    public String getLoginPageText(){
        waitUntilPresenceOfElementLocated(loginPageText,30);
        Reporter.log("Getting text from : " + loginPageText.toString() + "<br>");
        log.info("Getting text from " +loginPageText.toString());
        return getTextFromElement(loginPageText);
    }

    public void loginToNopCommerce(String username,String password){
        enterEmailId(username);
        enterPassword(password);
        clickOnLoginButton();


    }

}
