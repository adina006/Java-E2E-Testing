package com.expedia.factories;

import com.expedia.pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    public static Object initElements;

    public static SignInPage getSignInPage(WebDriver driver){
       return new SignInPage(driver);

    }

    public static HomePage getHomePage(WebDriver driver){
        return new HomePage(driver);
    }

    public static FlightsPages getFlightsPage(WebDriver driver) {
        return new FlightsPages(driver);
    }

    public static TicketPages getTicketPage(WebDriver driver) {
        return new TicketPages(driver);
    }

}
