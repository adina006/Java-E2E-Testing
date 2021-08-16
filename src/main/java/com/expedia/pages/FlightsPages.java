package com.expedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsPages extends BasePage {


    @FindBy(xpath = "//*[@id='uitk-tabs-button-container']/div[1]/li[2]/a")
    WebElement btn_oneWay;

    @FindBy(xpath = "//*[@id='location-field-leg1-origin-menu']/div[1]/button")
    WebElement btn_leavingFrom;

    @FindBy(xpath = "//*[@id='location-field-leg1-origin']")
    WebElement input_leavingFrom;

    @FindBy(xpath = "//*[@id='location-field-leg1-origin-menu']/div[2]/ul/li[2]/button")
    WebElement select_CityFrom;

    @FindBy(xpath = "//*[@id='location-field-leg1-destination-menu']/div[1]/button")
    WebElement btn_goingTo;

    @FindBy(xpath = "//*[@id='location-field-leg1-destination']")
    WebElement input_goingTo;

    @FindBy(xpath = "//*[@id='location-field-leg1-destination-menu']/div[2]/ul/li[1]/button")
    WebElement select_CityTo;

    @FindBy(xpath = "//*[@id='d1-btn']")
    WebElement btn_datePicker;

    @FindBy(xpath = "//*[@id='wizard-flight-tab-oneway']/div[2]/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]")
    WebElement choose_MonthAndYear;

    @FindBy(xpath = "//*[@id='wizard-flight-tab-oneway']/div[2]/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div[1]/h2")
    WebElement str_MonthAndYear;

    @FindBy(xpath = "//*[@id='wizard-flight-tab-oneway']/div[2]/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/button[2]")
    WebElement btn_Nextdate;

    @FindBy(xpath = "//*[@id='wizard-flight-tab-oneway']/div[2]/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div[1]/table/tbody/tr/td/button")
    List<WebElement> btn_allDates;

    @FindBy(xpath = "//*[@id='wizard-flight-tab-oneway']/div[2]/div[2]/div/div/div/div/div[2]/div/div[3]/button")
    WebElement btn_Done;

    @FindBy(xpath = "//*[@id='wizard-flight-pwa-1']/div[3]/div[2]/button")
    WebElement btn_Search;

    public FlightsPages(WebDriver driver) {
        super(driver);
    }

    //click oneWay
    public FlightsPages chooseOneWay() {
        btn_oneWay.click();
        return this;
    }

    //input city name for leavingFrom
    public FlightsPages leavingFrom(String city) {
        btn_leavingFrom.click();
        input_leavingFrom.sendKeys(city);
        select_CityFrom.click();
        return this;
    }

    //input city name for goingTo
    public FlightsPages goingTo(String city) {
        btn_goingTo.click();
        input_goingTo.sendKeys(city);
        select_CityTo.click();
        return this;
    }

    //pick a date
    public FlightsPages datePicker(String monthAndYear, String expect_day) {
        btn_datePicker.click();
        while (true) {
            String text = str_MonthAndYear.getText();
            if (text.equals(monthAndYear)) {
                break;
            } else {
                btn_Nextdate.click();
            }
        }
        List<WebElement> allDates = btn_allDates;
        for (WebElement ele : allDates) {
            String day = ele.getAttribute("data-day");
            if (day.equals(expect_day)) {
                ele.click();
            }

        }
        btn_Done.click();
        return this;
    }

    public FlightsPages searchFlight() {
        btn_Search.click();
        return this;
    }
}





