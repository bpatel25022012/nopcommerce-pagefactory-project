package com.demo.nopcommerce.testsuit;


import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.RegistrationPage;
import com.demo.nopcommerce.resources.testdata.TestData;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.demo.nopcommerce.utility.Utility.getRandomString;

/*
Created By Bhavesh
*/

public class RegistrationTestWithDataProvider extends TestBase {
    String email = null;
    String email1 = null;
    String password = null;
    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeMethod(groups = {"sanity","smoke","regression"})

    public void setup(){

        homePage = new HomePage();
        registrationPage = new RegistrationPage();
        email= "Rocky"+ getRandomString(5)+"@gmail.com";
        email1= "Ricky"+getRandomString(4)+"@hotmail.com";
        password = "Rocky"+getRandomString(3);

    }

    @Test (priority = 0,groups = {"sanity"})

    public void userShouldNavigateToRegistrationPage(){
        homePage.clickOnRegisterLink();
        String expectedText = "Your Personal Details";
        String actualText = registrationPage.personalDetailsMsg();
        Assert.assertEquals(expectedText,actualText);
    }
@Test (priority = 1, groups = {"smoke"},dataProvider = "Registration Data", dataProviderClass = TestData.class)
    public void userShouldRegisterSuccessFully(String firstname,String lastname ,String date , String month , String year,String companyname){
        homePage.clickOnRegisterLink();
        registrationPage.clickOnGenderButton();
        registrationPage.registerToNopCommerce(firstname,lastname,date,month,year,companyname);
        registrationPage.enterEmailId(email);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(password);
        registrationPage.clickOnRegistrationBtn();
        String expectedText = "Your registration completed";
        String actualText = registrationPage.getRegistrationText();
        Assert.assertEquals(expectedText,actualText);

}
    @Test (priority = 2,groups = {"regression"},dataProvider = "Registration Data", dataProviderClass = TestData.class)

    public void verifySuccessfullRegistrationPageMessage(String firstname,String lastname ,String date , String month , String year,String companyname){
        homePage.clickOnRegisterLink();
        registrationPage.clickOnGenderButton();
        registrationPage.registerToNopCommerce(firstname,lastname,date,month,year,companyname);
        registrationPage.enterEmailId(email1);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(password);
        registrationPage.clickOnRegistrationBtn();

        String expectedText = "Your registration completed in our store";
        String actualText = registrationPage.getRegistrationText();
        Assert.assertEquals(expectedText,actualText);

    }


}
