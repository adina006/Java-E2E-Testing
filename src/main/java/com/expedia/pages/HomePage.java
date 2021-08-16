package com.expedia.pages;

import com.expedia.utils.Log4jHelper;
import com.expedia.utils.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    private static final Logger logger = Logger.getLogger(HomePage.class);
    WebDriver driver;

    By lnk_footerSession = By.xpath("//*[@id='app-layer-base']/div[1]/div/div[2]/footer/div/div/ul[1]");

    By lnk_firstColumn = By.xpath("//*[@id='app-layer-base']/div[1]/div/div[2]/footer/div/div/ul[1]/li[2]/ul");

    By lnk_tagName = By.tagName("a");


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //landing on the homepage
    public HomePage isAtHomePage() {
        try {
            String expectedTitle = "Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More";
            String actualTitle = driver.getTitle();
            System.out.println(actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle);
            logger.info("HomePage is Title is as expected" + expectedTitle + "vs" + actualTitle);
        }catch (Exception ex) {
            Log4jHelper.error(logger, ex);
            throw ex;
        }
        return this;
    }

    //At footer session
    public HomePage isAtFooter(String s) {
        SeleniumHelper.scrollDown(driver,s);
        SeleniumHelper.waitForElementPresent(driver,10,lnk_footerSession);
        return this;
    }

    //get footer size
    public HomePage getFooterLinkSize() {
        WebElement footerDriver = driver.findElement(lnk_footerSession);
        System.out.println(footerDriver.findElements(lnk_tagName).size());
        return this;
    }

    //click all links on first column on new tab
    public void clickAllLinksOnFirstColumnAndGetTheTitle() {
        WebElement firstColumn = driver.findElement(lnk_firstColumn);
        int firstColumnSize = firstColumn.findElements(lnk_tagName).size();
        System.out.println(firstColumnSize);
        for (int i=1; i < firstColumnSize; i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumn.findElements(lnk_tagName).get(i).sendKeys(clickOnLinkTab);
        }

            Set<String> windows= driver.getWindowHandles();
            Iterator<String> iterator =  windows.iterator();

            while(iterator.hasNext())
            {
                driver.switchTo().window(iterator.next());
                System.out.println(driver.getTitle());
            }
        }


    }



