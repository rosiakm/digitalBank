package DigitalBank.Pages;

import DigitalBank.Helpers.Data;
import DigitalBank.Helpers.ExcelReader;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Login extends BasePage
{
    public Login()
    {
        super();
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href='/signup']")
    private WebElement signUpLink;

    @FindBy(xpath = "//span[@class='badge badge-pill badge-success']")
    private WebElement successAlert;

    @FindBy(css = "span[class='badge badge-pill badge-danger']")
    private WebElement errorAlert;

    Faker faker = new Faker();

    public void logInWithInvalidData()
    {
        usernameInput.sendKeys(faker.name().username());
        passwordInput.sendKeys(faker.internet().password());
        signInButton.click();
    }

    public void logInWithValidData(List<Data> logData)
    {
        for (Data login : logData)
        {
            usernameInput.sendKeys(login.getUsername());
            passwordInput.sendKeys(login.getPassword());
        }
        signInButton.click();
    }

    public void openARegistrationForm()
    {
        signUpLink.click();
    }

    public void checkThatSignUpSucceeded()
    {
        String actual = successAlert.getText();
        String expected = "Success";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public void checkThatLogInFailed()
    {
        String actual = errorAlert.getText();
        String expected = "Error";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
