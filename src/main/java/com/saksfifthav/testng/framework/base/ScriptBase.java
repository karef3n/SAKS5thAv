package com.saksfifthav.testng.framework.base;

import extentreport.ExtentTestNgListener;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import utils.ApplicationFactory;
import utils.DriverFactory;
import utils.Helper;

import java.util.concurrent.TimeUnit;

//@Listeners(ExtentTestNgListener.class)
public class ScriptBase extends Helper {
      protected WebDriver driver = null;
    protected ApplicationController saksFifth;
    @BeforeClass
    public void beforeClass(){

    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("FF") String browser ){
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        DriverFactory.getInstance().getDriver().manage().deleteAllCookies();
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        saksFifth = ApplicationFactory.getInstance().getApplicationController();
         driver = DriverFactory.getInstance(browser).getDriver();

    }



    @AfterMethod
    public void tearDown(){

       //DriverFactory.getInstance().removeDriver();
        saksFifth= null;


    }
    @AfterClass
    public void afterClass(){


    }

}
