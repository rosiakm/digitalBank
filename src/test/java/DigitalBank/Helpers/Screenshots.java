package DigitalBank.Helpers;

import DigitalBank.Config.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots
{
    public static byte[] takeScreenshot(WebDriver driver)
    {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
