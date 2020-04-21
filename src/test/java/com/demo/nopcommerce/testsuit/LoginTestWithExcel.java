package com.demo.nopcommerce.testsuit;

import com.demo.nopcommerce.excelutility.ExcelUtility;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created By Bhavesh
 */
public class LoginTestWithExcel extends TestBase {
    public static final String File_Path = System.getProperty("user.dir")+ "/src/test/java/com/demo/nopcommerce/resources/testdata/NopExcelData.xlsx";
    HomePage homePage;
    LoginPage loginPage;
    @BeforeClass
    public void setExcel(){
        // Tell the code about the location of Excel File
        try {
            ExcelUtility.setExcelFile(File_Path,"LoginTest");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @DataProvider(name="loginData")
    public Object[][] getData(){
        Object[][] data = ExcelUtility.getTestData("LoginData");
        return data;
    }

    @BeforeMethod

    public void setUp(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(dataProvider = "loginData")
    public void doLogin(String username , String password){
        homePage.clickOnLoginLink();
        loginPage.waitUntilVisibility();
        loginPage.loginToNopCommerce(username,password);
    }


}
