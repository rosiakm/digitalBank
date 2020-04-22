package DigitalBank.Tests;

import DigitalBank.Config.DriverSetUp;
import DigitalBank.Pages.Login;
import org.testng.annotations.Test;

public class LoginTest extends DriverSetUp
{
    Login login = new Login();

    @Test
    public void logInWithValidDataTest()
    {

    }

    @Test
    public void logInWithInvalidDataTest()
    {
        login.logInWithInvalidData();
    }
}
