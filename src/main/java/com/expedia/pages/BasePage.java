package com.expedia.pages;

import com.expedia.utils.Log4jHelper;
import com.expedia.utils.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    WebDriver driver;

    By btn_finalSignIn = By.xpath("//*[@id='app']/div[1]/div/div[1]/header/header/div/div/div[2]/div/div/div[2]/a");
    By btn_Flights = By.xpath("//*[@id='wizardMainRegionV2']/div/div/div[2]/div/div/ul/li[2]/a/span");

    private static final Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("Page Factory initialized");
        logger.info("Base Page Constructor is called");
    }

    //SignIn content opens
    public HomePage isAtSignInBtn() {
        SeleniumHelper.waitForElementPresent(driver, 100, btn_finalSignIn);
        return new HomePage(driver);

    }

    //click signIn Page
    public HomePage goToSignInPage() {
        try {
            driver.findElement(btn_finalSignIn).click();
            logger.info("Going to SignIn Page");
        }catch (Exception ex){
            Log4jHelper.error(logger,ex);
            throw ex;
        }
        return new HomePage(driver);
    }

    //wait flights button to be clickable
    public HomePage isAtFlightsBtn() {
        SeleniumHelper.waitForElementPresent(driver, 20, btn_Flights);
        return new HomePage(driver);
    }

    //click flight button
    public HomePage goToFlightsPage() {
        driver.findElement(btn_Flights).click();
        return new HomePage(driver);
    }

    //navigate to main page
    public void navigateToMainPage() {
        driver.navigate().to("https://www.expedia.com/");
    }


}