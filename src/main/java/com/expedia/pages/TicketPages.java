package com.expedia.pages;

import com.expedia.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketPages extends BasePage {


    By checkBox_Content = By.xpath("//*[@id='app-layer-base']/div[2]/div[3]/div[1]/aside/fieldset/fieldset[3]/div[2]/div/div[1]");

    @FindBy(xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/aside/fieldset/fieldset[3]/div[2]/div/div[1]/input")
    List<WebElement> checkBox_Airlines;

    @FindBy(xpath = "//*[@id='listings-sort']")
    WebElement select_price;

    @FindBy(xpath = "//*[@id='app-layer-manager']/div/div[2]/div[3]/div[1]/section/main/ul/li[1]/div/div/div/button")
    WebElement btn_tickets;
//    @FindBy(xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/section/main/ul/li/div/div/div/button")
//    List<WebElement> btn_tickets;


    @FindBy(xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/section/main/div[6]/section/div[2]/div/div[3]/div[2]/div/div/ul/li/div/button")
    WebElement btn_ticketSelect;

    @FindBy(xpath = "//*[@id='app-layer-forced-choice-modal-dialog']/div[2]/div/div/div[2]/div[2]/div/a[2]")
    WebElement btn_noThanks;

    public TicketPages(WebDriver driver) {
        super(driver);
    }

    public TicketPages isAtTicketPages() {
        SeleniumHelper.waitForElementPresent(driver, 50, checkBox_Content);
        return this;
    }

    public TicketPages pickAirlines(String theAirline) {
        List<WebElement> airlines = checkBox_Airlines;
        for (WebElement ele : airlines) {
            String airline = ele.getAttribute("Value");
            System.out.println(airline);
            if (airline.equalsIgnoreCase(theAirline)) {
                ele.click();
            }
        }
        return this;
    }

    public TicketPages sortByPrice(String sortedPrice) {
        SeleniumHelper.selectByVisibleText(select_price,sortedPrice);
        return this;
    }

    public TicketPages selectTicket(String s) {
        SeleniumHelper.scrollDown(driver, s);
        btn_tickets.click();
        return this;
    }

    public TicketPages finalTicketSelect(String s) {
        SeleniumHelper.scrollDown(driver,s);
        btn_ticketSelect.click();
        return this;
    }

    public void savingUp() {
        btn_noThanks.click();
    }

}
