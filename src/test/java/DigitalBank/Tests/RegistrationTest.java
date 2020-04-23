package DigitalBank.Tests;

import DigitalBank.Config.DriverSetUp;
import DigitalBank.Pages.FirstRegForm;
import DigitalBank.Pages.Login;
import DigitalBank.Pages.SecRegForm;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static DigitalBank.Helpers.ExcelWriter.excelWriter;

public class RegistrationTest extends DriverSetUp
{
    Login login = new Login();
    FirstRegForm form = new FirstRegForm();
    SecRegForm secForm = new SecRegForm();
    String path = "C:\\Users\\rosiakm\\IdeaProjects\\digitalBank\\loginBase.xlsx";

    @Test
    public void registrationTest() throws IOException
    {
        for (int i = 0; i<2; i++)
        {
            login.openARegistrationForm();
            form.fillRegistrationFormWithValidData();
            excelWriter(form.getLoginData(), new File(path));
            secForm.fillSecondRegistrationFormWithValidData();
            login.checkThatSignUpSucceeded();
        }
    }
}
