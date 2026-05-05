package com.automation.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class driverfactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {
        if (driver.get() == null) {

            if (browser.equalsIgnoreCase("Chrome")) {
                 ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--window-size=1920,1080");   
                    options.addArguments("--disable-gpu");             
                    driver.set(new ChromeDriver(options));

            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver.set(new FirefoxDriver(options));

            } else if (browser.equalsIgnoreCase("Edge")) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                driver.set(new EdgeDriver(options));

            } else {
                throw new RuntimeException("Browser not supported: " + browser);
            }
        }
        return driver.get();
    }

    public static WebDriver getDriver() {
        // Only RETURNS existing driver, never creates
        if (driver.get() == null) {
            throw new RuntimeException("Driver not initialized. Call initDriver() first.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}