package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/*
Created By Bhavesh
*/
public class RegistrationPage extends Utility {
    private static final Logger log = LogManager.getLogger(RegistrationPage.class.getName());
    //By personalDetailsText = By.xpath("//strong[contains(text(),'Your Personal Details')]");
    @FindBy(xpath ="//strong[contains(text(),'Your Personal Details')]" )
    WebElement personalDetailsText;
   // By genderRadioBtn = By.xpath("//span[@class=\"male\"]//input[@type='radio']");
    @FindBy(xpath ="//span[@class=\"male\"]//input[@type='radio']")
    WebElement genderRadioBtn;
   // By firstNameField = By.xpath("//input[@id=\"FirstName\"]");
    @FindBy (xpath ="//input[@id=\"FirstName\"]")
    WebElement firstNameField;
   // By lastNameField = By.xpath("//input[@id=\"LastName\"]");
    @FindBy (xpath ="//input[@id=\"LastName\"]")
    WebElement lastNameField;
   // By dateOfBirthDay = By.xpath("//select[@name=\"DateOfBirthDay\"]");
    @FindBy (xpath = "//select[@name=\"DateOfBirthDay\"]")
    WebElement dateOfBirthDay;
   // By dateOfBirthMonth = By.xpath("//select[@name=\"DateOfBirthMonth\"]");
    @FindBy (xpath = "//select[@name=\"DateOfBirthMonth\"]")
    WebElement dateOfBirthMonth;
   // By dateOfBirthYear = By.xpath("//select[@name=\"DateOfBirthYear\"]");
    @FindBy (xpath = "//select[@name=\"DateOfBirthYear\"]")
    WebElement dateOfBirthYear ;
  //  By emailField = By.xpath("//input[@id=\"Email\"]");
    @FindBy (xpath = "//input[@id=\"Email\"]")
    WebElement emailField ;
    // By companyNameFiled = By.xpath("//input[@id=\"Company\"]");
    @FindBy (xpath="//input[@id=\"Company\"]")
    WebElement companyNameFiled;
   // By passwordField = By.xpath("//input[@id=\"Password\"]");
    @FindBy (xpath="//input[@id=\"Password\"]")
    WebElement passwordField;
  //  By conPasswordField = By.xpath("//input[@id=\"ConfirmPassword\"]");
    @FindBy(xpath ="//input[@id=\"ConfirmPassword\"]" )
    WebElement conPasswordField;
   // By registerBtn = By.xpath("//input[@id=\"register-button\"]");
    @FindBy (xpath ="//input[@id=\"register-button\"]" )
    WebElement registerBtn;
   // By registrationMessage = By.xpath("//div[@class=\"result\"]");
    @FindBy (xpath ="//div[@class=\"result\"]" )
    WebElement registrationMessage;



    public String personalDetailsMsg(){
        Reporter.log("Getting text from : " +personalDetailsText.toString() + "<br>");
        log.info("Getting text from " +personalDetailsText.toString());
        return getTextFromElement(personalDetailsText);

    }
    public void clickOnGenderButton(){
        Reporter.log("selecting gender : " + genderRadioBtn.toString()+"<br>");
        log.info("selecting gender : " + genderRadioBtn.toString());
        clickOnElement(genderRadioBtn);
    }
    public void enterFirstName(String fname){
        Reporter.log("Entering firstname : " + fname +" "+ "to firstname field " + firstNameField.toString() + "<br>");
        log.info("Entering firstname : " + fname +" "+ "to firstname field " + firstNameField.toString());
        sendTextToElement(firstNameField,fname);
    }
    public void enterLastName(String lname){
        Reporter.log("Entering lastname : " + lname +" "+ "to lastname field " + lastNameField.toString() + "<br>");
        log.info("Entering lastname : " + lname +" "+ "to lastname field " + lastNameField.toString());
        sendTextToElement(lastNameField,lname);

    }
    public void enterDateOfBirth (String date){
        Reporter.log("selecting date : " + date +" "+ "into date field " + dateOfBirthDay.toString() + "<br>");
        log.info("selecting date : " + date +" "+ "into date field " + dateOfBirthDay.toString());
        sendTextToElement(dateOfBirthDay,date);

    }
    public void enterMonthOfBirth (String month){
        Reporter.log("selecting month : " + month +" "+ "into month field " + dateOfBirthMonth.toString() + "<br>");
        log.info("selecting month : " + month +" "+ "into month field " + dateOfBirthMonth.toString());
        sendTextToElement(dateOfBirthMonth,month);
    }
    public void enterYearOfBirth (String year){
        Reporter.log("selecting year : " + year+" "+ "into month field " + dateOfBirthYear.toString() + "<br>");
        log.info("selecting year : " + year +" "+ "into month field " + dateOfBirthYear.toString());
        sendTextToElement(dateOfBirthYear,year);
    }
    public void enterEmailId(String Email){
        Reporter.log("Entering email address : " + Email +" "+ " to email field : " + emailField.toString() + "<br>");
        log.info("Entering email address : " + Email +" "+ " to email field : " + emailField.toString());
        sendTextToElement(emailField,Email);
    }
    public void enterCompanyName(String compname){
        Reporter.log("Entering company name : " + compname +" "+ " to email field : " + companyNameFiled.toString() + "<br>");
        log.info("Entering company name : " + compname +" "+ " to email field : " + companyNameFiled.toString());
        sendTextToElement(companyNameFiled,compname);
    }
    public void enterPassword (String password){
        Reporter.log("Entering password : " + password +" "+ " to password field : " + passwordField.toString() + "<br>");
        log.info("Entering password : "+ password +" "+ " to password field :" + passwordField.toString());
        sendTextToElement(passwordField, password);

    }
    public void enterConfirmPassword (String conPassword){
        Reporter.log("Entering confirm password : " + conPassword +" "+ " to password field : " + conPasswordField.toString() + "<br>");
        log.info("Entering confirm password : "+ conPassword +" "+ " to password field :" + conPasswordField.toString());
      sendTextToElement(conPasswordField,conPassword);

    }
    public void clickOnRegistrationBtn(){
        Reporter.log("Clicking on register button : " + registerBtn.toString() + "<br>");
        log.info("Clicking on register button : " + registerBtn.toString());
        clickOnElement(registerBtn);
    }
    public String getRegistrationText(){
        Reporter.log("Getting text from page: " + registrationMessage.toString() + "<br>");
        log.info("Getting text from page: " +registrationMessage.toString());
        return getTextFromElement(registrationMessage);
    }
    public void registerToNopCommerce(String firstname,String lastname ,String date , String month , String year,String companyname){
        enterFirstName(firstname);
        enterLastName(lastname);
        enterDateOfBirth(date);
        enterMonthOfBirth(month);
        enterYearOfBirth(year);
        enterCompanyName(companyname);



    }
}
