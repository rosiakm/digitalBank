package DigitalBank.Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void openNewSavingsAccount()
    {
        savingsRadioButton.click();
        individualRadioButton.click();
        nameInput.sendKeys("My Savings");
        initialDepositInput.sendKeys("400.000");
        submitButton.click();
    }

    public void checkThatNewSavingsFormOpened()
    {
        String actual = newSavingsHeader.getText();
        String expected = "New Savings Account";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
