package com.automation.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class drivermanager {
    private static WebDriver driver;

    public static WebDriver init(){
        if(driver == null){
            driver = new ChromeDriver();   
            driver.manage().window().maximize(); 
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
