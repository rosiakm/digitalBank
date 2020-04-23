package DigitalBank.Tests;

import DigitalBank.Config.DriverSetUp;
import DigitalBank.Pages.Login;
import DigitalBank.Pages.MainView;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static DigitalBank.Helpers.ExcelReader.excelReader;

public class LoginTest extends DriverSetUp
{
    Login login = new Login();
    MainView mv = new MainView();

    @Test
    public void logInWithValidDataTest() throws IOException
    {
        login.logInWithValidData(excelReader(new File("loginBase.xlsx")));
        mv.checkThatLogInSucceeded();
    }

    @Test
    public void logoutTest() throws IOException
    {
        login.logInWithValidData(excelReader(new File("loginBase.xlsx")));
        mv.logOut();
        login.checkThatLogoutCompleted();
    }

    @Test
    public void logInWithInvalidDataTest()
    {
        login.logInWithInvalidData();
        login.checkThatLogInFailed();
    }
}
