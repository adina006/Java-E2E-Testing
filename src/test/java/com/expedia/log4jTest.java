package com.expedia;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class log4jTest {

    private static final Logger logger = Logger.getLogger(log4jTest.class);
    @Test
    public void test() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        Date currentDate = new Date();
        String timeStamp = dateFormat.format(currentDate);
        System.setProperty("currenttime", timeStamp);  //creating a timeStamp


        String log4jFilePath = System.getProperty("user.dir") + "//src//main//resources//log4j//log4j.properties";
        PropertyConfigurator.configure(log4jFilePath);

        //try and catch the excepion
        try{
            int i = 10/0;
        }
        catch(ArithmeticException ex) {
            logger.error("Exception is catched, message : " + ex.getMessage() + ex);
            throw ex;
        }
//        logger.info("First Log4j Message");
//        logger.error("First Error");
//        logger.warn("First Waring");
//        logger.debug("First Debug");
//        logger.fatal("first fatal");
    }
}