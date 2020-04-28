package DigitalBank.Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static DigitalBank.Config.DriverFactory.getDriver;
import static DigitalBank.Helpers.Screenshots.takeScreenshot;

public class NewSavings extends BasePage
{
    @FindBy(css = "strong[class='card-title text-white']")
    private WebElement newSavingsHeader;

    @FindBy(id = "Savings")
    private WebElement savingsRadioButton;

    @FindBy(id = "Individual")
    private WebElement individualRadioButton;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "openingBalance")
    private WebElement initialDepositInput;

    @FindBy(id = "newSavingsSubmit")
    private WebElement submitButton;

    public Savings openNewSavingsAccount()
    {
        savingsRadioButton.click();
        individualRadioButton.click();
        nameInput.sendKeys("My Savings");
        initialDepositInput.sendKeys("400.000");
        takeScreenshot(getDriver());
        submitButton.click();

        checkThatNewSavingsFormOpened();

        return new Savings();
    }

    public void checkThatNewSavingsFormOpened()
    {
        String actual = newSavingsHeader.getText();
        String expected = "New Savings Account";
        takeScreenshot(getDriver());
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
