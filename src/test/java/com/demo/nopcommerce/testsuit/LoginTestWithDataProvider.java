package com.demo.nopcommerce.testsuit;

import com.demo.nopcommerce.loadproperty.LoadProperty;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.resources.testdata.TestData;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

/*
Created By Bhavesh
*/
public class LoginTestWithDataProvider extends TestBase {


    HomePage homePage;
    LoginPage loginPage ;

    @BeforeMethod(groups = {"sanity","smoke","regression"})

    public void setUP(){

        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test (priority = 0,groups = {"sanity"})

    public void verifyUserShouldNavigateToLoginPage(){
        homePage.clickOnLoginLink();
        String expectedText = "Welcome, Please Sign In!";
        String actualText = loginPage.getWelcomeText();
        Assert.assertEquals(expectedText, actualText);

    }
    @Test (priority = 1, groups = {"smoke"} , dataProvider = "Login Data",dataProviderClass = TestData.class)

    public void verifyUserShouldLoginSuccessfully(String username , String password){
          homePage.clickOnLoginLink();
          loginPage.waitUntilVisibility();
          loginPage.loginToNopCommerce(username,password);
          String expectedText = "Welcome to our store";
          String actualText = loginPage.getLoginPageText();
          Assert.assertEquals(expectedText,actualText);
    }
    @Test (priority = 2,groups = {"regression"}, dataProvider = "Login Data",dataProviderClass = TestData.class)

    public void verifySuccessfullLoginPageMessage(String username , String password){
        homePage.clickOnLoginLink();
        loginPage.waitUntilVisibility();
        loginPage.loginToNopCommerce(username , password);
        String expectedText = "Welcome to our store of UK";
        String actualText = loginPage.getLoginPageText();
        Assert.assertEquals(expectedText,actualText);
    }
}
