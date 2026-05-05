package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.automation.Base.Basedriver;

public class Testcase1 extends Basedriver {
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/");
    }

    @Test(priority=1, description="validation url opening")
    public void openbrowser(){ 
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//li[contains(@class,'nav-item')]//a[text()='About']"))).click();
            
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[text()='About Selenium']"))).click();
    }

    @Test(priority=2, description="Validating all tab")
    public void clickingondownloads(){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Downloads"))).click();
    }
}