package com.automation.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverfactory {
     private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

     public static WebDriver initDriver(String browser) {

        if(driver.get() == null){

            if(browser.equalsIgnoreCase("Chrome")){
                driver.set(new ChromeDriver());
            }else if(browser.equalsIgnoreCase("Firefox")){
                driver.set(new FirefoxDriver());
            }else if(browser.equalsIgnoreCase("Edge")){
                driver.set(new EdgeDriver());
            }else{
                throw new RuntimeException("Browser not supported: "+browser);
            }
        }
        return getDriver();
     }

     public static WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sendbox");
        options.addArguments("--disable-dev-shm-usage");
        driver.set(new ChromeDriver(options));
        return driver.get();
     }

     public static void quitDriver(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
     }
}