package com.demo.nopcommerce.testsuit;

import com.demo.nopcommerce.excelutility.ExcelUtility;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.pages.RegistrationPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.demo.nopcommerce.utility.Utility.getRandomString;

/**
 * Created By Bhavesh
 */
public class RegistrationTestWithExcel extends TestBase {
    public static final String File_Path = System.getProperty("user.dir")+ "/src/test/java/com/demo/nopcommerce/resources/testdata/NopExcelData.xlsx";
    String email = null;
    String email1 = null;
    String password = null;
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    @BeforeClass
    public void setExcel(){
        // Tell the code about the location of Excel File
        try {
            ExcelUtility.setExcelFile(File_Path,"RegistrationTest");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @DataProvider(name="registrationData")
    public Object[][] getData(){
        Object[][] data = ExcelUtility.getTestData("RegistrationData");
        return data;
    }

    @BeforeMethod

    public void setUp(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        email= "Rocky"+ getRandomString(5)+"@gmail.com";
        email1= "Ricky"+getRandomString(4)+"@hotmail.com";
        password = "Rocky"+getRandomString(3);

    }

    @Test(dataProvider = "registrationData")
    public void doRegistration(String firstname,String lastname ,String date , String month , String year,String companyname){
        homePage.clickOnRegisterLink();
        registrationPage.clickOnGenderButton();
        registrationPage.registerToNopCommerce(firstname,lastname,date,month,year,companyname);
        registrationPage.enterEmailId(email);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(password);
        registrationPage.clickOnRegistrationBtn();
    }


}
