package DigitalBank.Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static DigitalBank.Config.DriverFactory.getDriver;
import static DigitalBank.Helpers.Screenshots.takeScreenshot;

public class SecRegForm extends BasePage
{
    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "locality")
    private WebElement localityInput;

    @FindBy(id = "region")
    private WebElement regionInput;

    @FindBy(id = "postalCode")
    private WebElement postalCodeInput;

    @FindBy(id = "country")
    private WebElement countryInput;

    @FindBy(id = "homePhone")
    private WebElement homePhoneInput;

    @FindBy(id = "mobilePhone")
    private WebElement mobilePhoneInput;

    @FindBy(id = "workPhone")
    private WebElement workPhoneInput;

    @FindBy(id = "agree-terms")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    Faker faker = new Faker();

    public void fillSecondRegistrationFormWithValidData()
    {
        takeScreenshot(getDriver());
        addressInput.sendKeys(faker.address().streetAddress());
        localityInput.sendKeys(faker.address().cityName());
        regionInput.sendKeys(faker.address().state());
        postalCodeInput.sendKeys(faker.address().zipCode());
        countryInput.sendKeys(faker.address().country());
        String phoneNumber = faker.phoneNumber().cellPhone();
        homePhoneInput.sendKeys(phoneNumber);
        mobilePhoneInput.sendKeys(phoneNumber);
        workPhoneInput.sendKeys(phoneNumber);
        agreeCheckbox.click();
        takeScreenshot(getDriver());
        registerButton.click();
    }
}
