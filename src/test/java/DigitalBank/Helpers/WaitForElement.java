package DigitalBank.Helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static DigitalBank.Config.DriverFactory.getDriver;

public class WaitForElement
{
    public static void waitForElementToBeDisplayed(WebElement element)
    {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver());
        wait.withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
