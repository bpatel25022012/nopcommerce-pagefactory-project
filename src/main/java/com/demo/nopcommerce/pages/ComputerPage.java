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
public class ComputerPage extends Utility {
    private static final Logger log = LogManager.getLogger(ComputerPage.class.getName());
    @FindBy (xpath ="//h2[@class='title']//a[contains(text(),'Desktops')]")
    WebElement deskTops;
    @FindBy (xpath ="//h1[contains(text(),'Computers')]")
    WebElement computerPageText;


    public void clickOnDeskTops(){
        waitUntilPresenceOfElementLocated(deskTops,30);
        Reporter.log("clicking on desktops tab " +deskTops.toString()+"<br>");
        log.info("clicking on desktops tab " +deskTops.toString());
        clickOnElement(deskTops);
    }

    public String computerPageText(){
        Reporter.log("Getting text from : " + computerPageText.toString() + "<br>");
        log.info("Getting text from " +computerPageText.toString());
        return getTextFromElement(computerPageText);
    }
}
