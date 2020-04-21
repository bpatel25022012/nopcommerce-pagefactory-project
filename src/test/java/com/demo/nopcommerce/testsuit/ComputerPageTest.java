package com.demo.nopcommerce.testsuit;

import com.demo.nopcommerce.pages.ComputerPage;
import com.demo.nopcommerce.pages.DeskTopPage;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
Created By Bhavesh
*/
public class ComputerPageTest extends TestBase {

    HomePage homePage ;
    ComputerPage computerPage;
    DeskTopPage deskTopPage;

    @BeforeMethod (groups = {"sanity","smoke","regression"})

    public void setUp(){
        homePage = new HomePage();
        deskTopPage = new DeskTopPage();
        computerPage = new ComputerPage();
    }

    @Test (priority = 0,groups = {"sanity"})

    public void userShouldNavigateToComputersPage(){

        homePage.clickOnComputersLink();
        String expectedText = "Computers";
        String actualText = computerPage.computerPageText();
        Assert.assertEquals(expectedText,actualText);
    }
@Test (priority = 1, groups = {"smoke"})
    public void userShouldNavigateToDeskTopPage(){

        homePage.clickOnComputersLink();
        computerPage.clickOnDeskTops();
        String expectedText = "Desktops";
        String actualText = deskTopPage.DeskTopPageText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Test (priority = 2,groups = {"regression"})
    public void verifyDesktopsScreenMessage(){

        homePage.clickOnComputersLink();
        computerPage.clickOnDeskTops();
        String expectedText = "DeskTops & Laptops";
        String actualText = deskTopPage.DeskTopPageText();
        Assert.assertEquals(expectedText,actualText);

    }
}


