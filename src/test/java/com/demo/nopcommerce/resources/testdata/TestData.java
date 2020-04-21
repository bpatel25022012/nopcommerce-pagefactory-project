package com.demo.nopcommerce.resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created By Bhavesh
 */
public class TestData {

    @DataProvider(name="Login Data")
    public Object [][] getData(){
        return new Object[][]{
                {"alpha12@gmail.com","Tiger123"}
        };
    }
    @DataProvider(name = "Registration Data")
    public Object[][] getData1(){
        return new Object[][]{
                {"Bhavesh","Patel","4","April","1986","Best In Testing Ltd."}
        };
    }
}
