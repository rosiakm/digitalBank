package DigitalBank.Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static DigitalBank.Config.DriverFactory.getDriver;
import static DigitalBank.Helpers.Screenshots.takeScreenshot;

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

    @FindBy(linkText = "View Checking")
    private WebElement viewCheckingLink;

    @FindBy(id = "new-savings-menu-option")
    private WebElement newSavingsLink;

    @FindBy(linkText = "View Savings")
    private WebElement viewSavingsLink;

    @FindBy(css = "img[alt='User Avatar")
    private WebElement userAvatar;

    @FindBy(linkText = "Logout")
    private WebElement logoutButton;

    public void checkThatLogInSucceeded()
    {
        String actual = welcomeMessage.getText();
        String expected = "Welcome";
        takeScreenshot(getDriver());
        Assertions.assertThat(actual).contains(expected);
    }

    public NewChecking openNewCheckingForm()
    {
        checkingMenu.click();
        takeScreenshot(getDriver());
        newCheckingLink.click();

        return new NewChecking();
    }

    public NewSavings openNewSavingsForm()
    {
        savingsMenu.click();
        takeScreenshot(getDriver());
        newSavingsLink.click();

        return new NewSavings();
    }

    public Login logOut()
    {
        userAvatar.click();
        takeScreenshot(getDriver());
        logoutButton.click();
        takeScreenshot(getDriver());

        return new Login();
    }

    public Checking openViewChecking()
    {
        checkingMenu.click();
        viewCheckingLink.click();

        return new Checking();
    }

    public Savings openViewSavings()
    {
        checkingMenu.click();
        viewSavingsLink.click();

        return new Savings();
    }
}
