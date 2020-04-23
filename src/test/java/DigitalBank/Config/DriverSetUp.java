package DigitalBank.Config;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static DigitalBank.Config.DriverFactory.getDriver;
import static DigitalBank.Config.DriverFactory.quit;

public class DriverSetUp
{
    public WebDriver driver;
    Logger logger = Logger.getLogger(DriverSetUp.class);

    @BeforeTest
    public void setDriver()
    {
        logger.info("Driver is opening");
        driver = getDriver();
    }

    @AfterTest
    public void tearDown()
    {
        logger.info("Driver is closing");
        quit();
    }


}
