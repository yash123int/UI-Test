package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.automation.Driver.drivermanager;

@Listeners(Listener.class)
public class Testcase1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = drivermanager.init();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/");
    }

    @Test(priority=1, description="validation url opening")
    public void openbrowser(){ 
        //click on about button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("navbarDropdown"))).click();
            
        //click on anyone option from dropdown 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='About Selenium']"))).click();
    }

    @Test(priority=2, description="Validating all tab")
    public void clickingondownloads(){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Downloads"))).click();
    }

    @AfterMethod
    public void closedriver(){
        drivermanager.quitDriver();
    }

}
