package DigitalBank.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static DigitalBank.Config.DriverFactory.getDriver;
import static DigitalBank.Helpers.WaitForElement.waitForElementToBeDisplayed;

public abstract class BasePage
{
    @FindBy(xpath = "//div[@class='container']")
    private WebElement container;

    Logger logger = Logger.getLogger(BasePage.class);

    public BasePage()
    {
        logger.info("Page is loading");
        PageFactory.initElements(getDriver(), this);
        waitForElementToBeDisplayed(container);
    }
}
