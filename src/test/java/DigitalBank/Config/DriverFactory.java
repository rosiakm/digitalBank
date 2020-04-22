package DigitalBank.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory
{
    public static WebDriver driver;
    private DriverFactory(){}

    public static WebDriver getDriver()
    {
        if(driver == null)
        {
            getDriverType(DriverType.CHROME);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://dbankdemo.com/login");
        }
        return driver;
    }

    private static void getDriverType(DriverType driverType)
    {
        switch (driverType)
        {
            case CHROME:
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            break;
            case IE:
            {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            break;
            case FIREFOX:
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            break;
        }
    }

    public static void quit()
    {
        if(driver != null)
        {
            driver.quit();
        }
        driver = null;
    }
}
