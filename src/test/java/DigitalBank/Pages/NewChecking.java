package DigitalBank.Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewChecking extends BasePage
{
    @FindBy(css = "strong[class='card-title text-white']")
    private WebElement newCheckingHeader;

    @FindBy(id = "Standard Checking")
    private WebElement standardCheckingRadioButton;

    @FindBy(id = "Individual")
    private WebElement individualRadioButton;

    @FindBy(id = "name")
    private WebElement accountNameInput;

    @FindBy(id = "openingBalance")
    private WebElement initialAmountInput;

    @FindBy(css = "button[class='btn btn-primary btn-sm']")
    private WebElement submitButton;

    public void createNewCheckingAccount()
    {
        standardCheckingRadioButton.click();
        individualRadioButton.click();
        accountNameInput.sendKeys("Basic Account");
        initialAmountInput.sendKeys("100.000");
        submitButton.click();
    }

    public void checkThatNewCheckingFormOpened()
    {
        String actual = newCheckingHeader.getText();
        String expected = "New Checking Account";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
