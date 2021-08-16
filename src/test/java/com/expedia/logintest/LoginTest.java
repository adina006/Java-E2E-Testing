package com.expedia.logintest;

import com.expedia.base.TestBase;
import com.expedia.constants.Config;
import com.expedia.factories.PageFactory;
import com.expedia.pages.BasePage;
import com.expedia.pages.HomePage;
import com.expedia.pages.SignInPage;
import com.expedia.utils.ExcelHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {


    @Test
    public void loginTest() throws InterruptedException, IOException {

        String email = excelHelper.getCellData("loginTest1", "Email");
        String password = excelHelper.getCellData("loginTest1", "Password");

        //browser
        WebDriver driver = initDriver(browserName);
        goToUrl(driver, Config.URL);

        //HomePage and go to signIn Page
        PageFactory.getHomePage(driver)
                .isAtHomePage()
                .isAtSignInBtn()
                .goToSignInPage();

        //input email and password to signIn
        PageFactory.getSignInPage(driver)
                .isAtSignInPage()
                .SignIn(email, password);

        //navigateToMainPage
        PageFactory.getHomePage(driver)
                .navigateToMainPage();

        driver.quit();

    }

}
