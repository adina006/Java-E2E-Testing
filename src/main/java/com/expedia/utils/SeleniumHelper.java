package com.expedia.utils;

import com.expedia.constants.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumHelper {

    public static WebElement waitForElementPresent(WebDriver driver, long timeout, By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.manage().timeouts().implicitlyWait(Config.mediumTimeOut,TimeUnit.SECONDS);
        return elem;
    }

    public static void scrollDown(WebDriver driver, String s) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(s);
    }

    public static void selectByVisibleText(WebElement by,String s){
        Select price = new Select(by);
        price.selectByVisibleText(s);
    }
}
