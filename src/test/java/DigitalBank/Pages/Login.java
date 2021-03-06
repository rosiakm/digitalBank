package DigitalBank.Pages;

import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    Faker faker = new Faker();

    public void logInWithInvalidData()
    {
        usernameInput.sendKeys(faker.name().username());
        passwordInput.sendKeys("Password123");
        signInButton.click();
    }

    public void logInWithValidData()
    {

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

}
