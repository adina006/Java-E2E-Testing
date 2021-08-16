package com.expedia.flightsTest;

import com.expedia.base.TestBase;
import com.expedia.constants.Config;
import com.expedia.factories.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FlightsTest extends TestBase {

    @Test
    public void flightsTest() {
        WebDriver driver = initDriver(browserName);
        goToUrl(driver, Config.URL);

        //goToFlightsPage
        PageFactory.getHomePage(driver)
                .isAtFlightsBtn()
                .goToFlightsPage();

        //Pick city and dates to for flight
        PageFactory.getFlightsPage(driver)
                .chooseOneWay()
                .leavingFrom("MIA")
                .goingTo("URC")
                .datePicker("January 2020","20")
                .searchFlight();

        //Pick Ticket
        PageFactory.getTicketPage(driver)
                .isAtTicketPages()
                .pickAirlines("AC")
                .sortByPrice("Price (Highest)")
                .selectTicket("window.scrollBy(0,500)")
                .finalTicketSelect("window.scrollBy(0,700)")
                .savingUp();

        driver.quit();

    }

}
