package com.automation.Base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.Driver.driverfactory;

public class Basedriver {
    protected WebDriver driver;
    protected String browser_tools = "Chrome";

    @Parameters({"browser", "executionMode"})
    @BeforeClass(alwaysRun=true)
    public void setupClass(@Optional("chrome") String browser, @Optional("chrome") String executionMode){
        if(executionMode.equalsIgnoreCase("Class")){
            driver = driverfactory.initDriver(browser_tools);
        }
    }

    @Parameters({"browser", "executionMode"})
    @BeforeMethod(alwaysRun=true)
    public void setupMethod(@Optional("chrome") String browser, @Optional("chrome") String executionMode){
        if(executionMode.equalsIgnoreCase("Method")){
            driver = driverfactory.initDriver(browser_tools);
        }
    }
  
    @AfterClass(alwaysRun=true)
    public void killdriverClass(ITestContext context){
        String strictmode = context.getCurrentXmlTest().getParameter("executionMode");
        if("Method".equalsIgnoreCase(strictmode)){
            driverfactory.quitDriver();
        }
    }

    @AfterMethod(alwaysRun=true)
    public void killdrivermethod(ITestContext context){
        String strictmode = context.getCurrentXmlTest().getParameter("executionMode");
        if("Class".equalsIgnoreCase(strictmode)){
            driverfactory.quitDriver();
        }
    }
}
