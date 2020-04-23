package DigitalBank.Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainView extends BasePage
{
    @FindBy(xpath = "//ol/li[@class='active']")
    private WebElement welcomeMessage;

    @FindBy(xpath = ("(//a[@class='dropdown-toggle'])[1]"))
    private WebElement checkingMenu;

    @FindBy(id = "savings-menu")
    private WebElement savingsMenu;

    @FindBy(linkText = "New Checking")
    private WebElement newCheckingLink;

    @FindBy(id = "new-savings-menu-option")
    private WebElement newSavingsLink;

    public void checkThatLogInSucceeded()
    {
        String actual = welcomeMessage.getText();
        String expected = "Welcome";
        Assertions.assertThat(actual).contains(expected);
    }

    public void openNewCheckingForm()
    {
        checkingMenu.click();
        newCheckingLink.click();
    }

    public void openNewSavingsForm()
    {
        savingsMenu.click();
        newSavingsLink.click();
    }
}
