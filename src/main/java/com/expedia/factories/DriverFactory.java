package com.expedia.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();       //if the object is not in the map it won't execute

    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;

        browserName = browserName.toUpperCase();
        switch (browserName){
            case "Firefox":
                driver = drivers.get("Firefox");
                if(driver == null){
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//Drivers//geckodriver.exe");
                    driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                }
                break;
            case "Edge":
                driver = drivers.get("Edge");
                if (driver == null) {
                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//src//main//resources//Drivers//msedgedriver.exe");
                    driver = new InternetExplorerDriver();
                    drivers.put("Edge", driver);
                }
                break;
            case "Chrome":
                driver = drivers.get("Chrome");
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//Drivers//chromedriver.exe");
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                }
                break;
        }
        return driver;
    }
    public static void closeAllDriver(){
        for(String key: drivers.keySet()){
            drivers.get(key).quit();
        }
    }
                }
