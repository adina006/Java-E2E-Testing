package com.expedia.constants;



public class Config {
    public static final String URL = "https://www.expedia.com/";
//    public static final String BrowserName = "Chrome";
    public static final String ExcelFilePath = System.getProperty("user.dir") + "//src//main//resources//data//DemoExcel.xlsx";
    public static final String log4jFilePath=System.getProperty("user.dir") + "//src//main//resources//log4j//log4j.properties";
    public static final String mySqlConnString = "jdbc:mysql://localhost:3306/testdatas";
    public static final String mySqlUser ="root";
    public static final String mySqlPassword = "admin";
    public static final long mediumTimeOut = 15;
    public static final long smallTimeOut = 5;
    public static final long largeTimeOut = 30;
}
