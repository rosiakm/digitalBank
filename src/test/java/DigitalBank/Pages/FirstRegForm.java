package DigitalBank.Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.*;

import static DigitalBank.Helpers.PasswordGenerator.generatePassword;
import static DigitalBank.Helpers.RandomDates.randomDateGenerator;

public class FirstRegForm extends BasePage
{
    public FirstRegForm()
    {
        super();
    }

    @FindBy(id = "title")
    private WebElement titleSelect;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@value='M']")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//input[@value='F']")
    private WebElement femaleRadioButton;

    @FindBy(id = "dob")
    private WebElement dateOfBirthInput;

    @FindBy(id = "ssn")
    private WebElement socialSecurityNumberInput;

    @FindBy(id = "emailAddress")
    private WebElement eMailAddressInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    Faker faker = new Faker();
    List<String> loginData = new ArrayList<>();

    public List<String> fillRegistrationFormWithValidData()
    {
        new Select(titleSelect).selectByValue("Mr.");
        firstNameInput.sendKeys(faker.name().firstName());
        lastNameInput.sendKeys(faker.name().lastName());
        maleRadioButton.click();
        dateOfBirthInput.sendKeys(randomDateGenerator());
        socialSecurityNumberInput.sendKeys(getSocialSecurityNumber());
        String address = faker.internet().emailAddress();
        eMailAddressInput.sendKeys(address);
        String password = generatePassword(12);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        loginData.add(address);
        loginData.add(password);

        submitButton.click();

        return loginData;
    }

    public List<String> getLoginData()
    {
        List<String> dataList = new ArrayList<>();
        for (String data : loginData)
        {
            dataList.add(data);
        }

        return dataList;
    }

    public String getSocialSecurityNumber()
    {
        int first = faker.number().numberBetween(100,999);
        int second = faker.number().numberBetween(10,99);
        int third = faker.number().numberBetween(1000,9999);

        String.valueOf(first);
        String.valueOf(second);
        String.valueOf(third);

        return first + "-" + second + "-" + third;
    }

}
