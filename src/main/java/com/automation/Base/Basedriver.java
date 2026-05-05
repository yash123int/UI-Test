package com.automation.Base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.automation.Driver.driverfactory;

public class Basedriver {
    protected WebDriver driver;

    @Parameters({"browser", "executionMode"})
    @BeforeClass(alwaysRun = true)
    public void setupClass(@Optional("chrome") String browser,
                           @Optional("class") String executionMode) {
        if (executionMode.equalsIgnoreCase("Class")) {
            driver = driverfactory.initDriver(browser);
            System.out.println("🟢 CLASS MODE — Browser launched once");
        }
    }

    @Parameters({"browser", "executionMode"})
    @BeforeMethod(alwaysRun = true)
    public void setupMethod(@Optional("chrome") String browser,
                            @Optional("class") String executionMode) {
        if (executionMode.equalsIgnoreCase("Method")) {
            driver = driverfactory.initDriver(browser);
            System.out.println("🟢 METHOD MODE — Fresh browser launched");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void killdriverMethod(ITestContext context) {
        String mode = context.getCurrentXmlTest().getParameter("executionMode");
        if ("Method".equalsIgnoreCase(mode)) {
            driverfactory.quitDriver();
            System.out.println("🔴 METHOD MODE — Browser killed");
        }
    }

    @AfterClass(alwaysRun = true)
    public void killdriverClass(ITestContext context) {
        String mode = context.getCurrentXmlTest().getParameter("executionMode");
        if ("Class".equalsIgnoreCase(mode)) {
            driverfactory.quitDriver();
            System.out.println("🔴 CLASS MODE — Browser killed once");
        }
    }
}