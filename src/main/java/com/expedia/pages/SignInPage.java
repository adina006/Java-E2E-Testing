package com.expedia.pages;

import com.expedia.factories.PageFactory;
import com.expedia.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignInPage extends BasePage {

    WebDriver driver;

    By form_signIn = By.xpath("//*[@id='content-box']");

    @FindBy(xpath = "//*[@id='signin-loginid']")
    WebElement input_email;
    @FindBy(xpath ="//*[@id='signin-password']" )
            WebElement input_password;
    @FindBy(xpath ="//*[@id='submitButton']" )
            WebElement btn_signIn;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //we are at the sign_in page
    public SignInPage isAtSignInPage() {
        SeleniumHelper.waitForElementPresent(driver,50,form_signIn);
        return new SignInPage(driver);
    }

    //SignIn and input signIn info
    public SignInPage SignIn(String email, String password) {
        input_email.sendKeys(email);
        input_password.sendKeys(password);
        btn_signIn.click();
        return new SignInPage(driver);


    }


}