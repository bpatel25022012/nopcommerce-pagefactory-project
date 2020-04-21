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
public class DeskTopPage extends Utility {
    private static final Logger log = LogManager.getLogger(DeskTopPage.class.getName());
    @FindBy (xpath = "//h1[contains(text(),'Desktops')]")
    WebElement deskTopText;

    public String DeskTopPageText(){
        Reporter.log("Getting text from : " + deskTopText.toString() + "<br>");
        log.info("Getting text from " +deskTopText.toString());
        return getTextFromElement(deskTopText);
    }

}

