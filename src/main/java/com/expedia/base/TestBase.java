package com.expedia.base;

import com.expedia.constants.Config;
import com.expedia.utils.DataBaseHelper;
import com.expedia.utils.ExcelHelper;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected String browserName;
    protected ExcelHelper excelHelper;
    protected DataBaseHelper dataBaseHelper;

    @Parameters("Browser")
    @BeforeTest
    public void init(String browserName) throws IOException, SQLException {
        this.browserName = browserName;

        //ExcelHelper configuration
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(Config.ExcelFilePath);
        excelHelper.setExcelSheet("LoginTest");

        //DataBaseHelper configuration
        dataBaseHelper = new DataBaseHelper();
        dataBaseHelper.createConnection(Config.mySqlConnString,Config.mySqlUser,Config.mySqlPassword);


        //log4j configuration
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        Date currentDate = new Date();
        String timeStamp = dateFormat.format(currentDate);
        System.setProperty("currenttime", timeStamp);  //creating a timeStamp

        PropertyConfigurator.configure(Config.log4jFilePath);

    }

    public WebDriver initDriver(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//main//resources//Drivers//geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "IE":

                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//src//main//resources//Drivers//IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//Drivers//chromedriver.exe");
                driver = new ChromeDriver();
                break;

            default:
                System.out.println("Browser is not supported");
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }

    public void goToUrl(WebDriver driver, String url) {
        driver.get(url);
    }


}
