package DigitalBank.Tests;

import DigitalBank.Config.DriverSetUp;
import DigitalBank.Pages.Login;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static DigitalBank.Helpers.ExcelReader.excelReader;

public class DigitalBankTest extends DriverSetUp
{
    Login login = new Login();

    @Test(priority = 1)
    public void registrationTest() throws IOException
    {
        login.openARegistrationForm()
             .fillRegistrationFormWithValidData()
             .fillSecondRegistrationFormWithValidData()
             .checkThatSignUpSucceeded();
    }

    @Test(priority = 3)
    public void logInWithValidDataTest() throws IOException
    {
        login.logInWithValidData(excelReader(new File("loginBase.xlsx")))
                .checkThatLogInSucceeded();
    }

    @Test (priority = 4)
    public void logoutTest() throws IOException
    {
        login.logInWithValidData(excelReader(new File("loginBase.xlsx")))
                .logOut()
                .checkThatLogoutCompleted();
    }

    @Test (priority = 2)
    public void logInWithInvalidDataTest()
    {
        login.logInWithInvalidData()
                .checkThatLogInFailed();
    }

    @Test(priority = 5)
    public void createNewCheckingAccountTest() throws IOException
    {
        login.logInWithValidData(excelReader(new File("loginBase.xlsx")))
                .openNewCheckingForm()
                .createNewCheckingAccount();
    }

    @Test (priority = 6)
    public void createNewSavingsAccountTest() throws IOException
    {
        login.logInWithValidData(excelReader(new File("loginBase.xlsx")))
                .openNewSavingsForm()
                .openNewSavingsAccount();
    }
}
