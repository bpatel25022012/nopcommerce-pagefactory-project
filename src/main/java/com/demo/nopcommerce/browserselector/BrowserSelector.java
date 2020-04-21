package com.demo.nopcommerce.browserselector;

import com.demo.nopcommerce.basepage.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

/*
Created By Bhavesh
*/
public class BrowserSelector extends BasePage {
    private static final Logger log = LogManager.getLogger(BrowserSelector.class.getName());
    String projectPath = System.getProperty("user.dir");

    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/driver/chromedriver.exe");
            Reporter.log("launching the Chrome browser");
            log.info("launching the  Chrome browser");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/driver/geckodriver.exe");
            Reporter.log("launching the Firefox browser");
            log.info("launching the Firefox browser");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", projectPath + "/driver/IEDriverServer.exe");
            Reporter.log("launching the IE browser");
            log.info("launching the IE browser");
            driver = new InternetExplorerDriver();
        } else {
            Reporter.log("Wrong browser");
            log.info("Wrong browser");
            System.out.println("Wrong browser");
        }


    }



}
