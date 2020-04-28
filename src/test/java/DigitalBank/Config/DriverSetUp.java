package DigitalBank.Config;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static DigitalBank.Config.DriverFactory.*;

public class DriverSetUp
{
    public WebDriver driver;
    Logger logger = Logger.getLogger(DriverSetUp.class);

    @BeforeMethod
    public void setDriver()
    {
        logger.info("Driver is opening");
        driver = getDriver();
    }

    @AfterMethod
    public void tearDown()
    {
        logger.info("Driver teared down");
        quit();
    }


}
