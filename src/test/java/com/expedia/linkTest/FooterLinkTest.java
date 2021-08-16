package com.expedia.linkTest;

import com.expedia.base.TestBase;
import com.expedia.constants.Config;
import com.expedia.factories.PageFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FooterLinkTest extends TestBase {


    @Test
    public void footerLinkTest() {
        WebDriver driver = initDriver(browserName);
        goToUrl(driver, Config.URL);

        //footer links
        PageFactory.getHomePage(driver)
                .isAtFooter("window.scrollBy(0,5000)")
                .getFooterLinkSize()
                .clickAllLinksOnFirstColumnAndGetTheTitle();

        driver.quit();
    }

}
