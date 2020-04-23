package DigitalBank.Tests;

import DigitalBank.Config.DriverSetUp;
import DigitalBank.Pages.Login;
import DigitalBank.Pages.MainView;
import DigitalBank.Pages.NewChecking;
import DigitalBank.Pages.NewSavings;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static DigitalBank.Helpers.ExcelReader.excelReader;

public class CreateNewAccountTest extends DriverSetUp
{
    Login login = new Login();
    MainView mv = new MainView();
    NewChecking nc = new NewChecking();
    NewSavings ns = new NewSavings();

    @Test
    public void createNewCheckingAccountTest() throws IOException
    {
        login.logInWithValidData(excelReader(new File("loginBase.xlsx")));
        mv.openNewCheckingForm();
        nc.checkThatNewCheckingFormOpened();
        nc.createNewCheckingAccount();
    }

    @Test
    public void createNewSavingsAccountTest() throws IOException
    {
        login.logInWithValidData(excelReader(new File("loginBase.xlsx")));
        mv.openNewSavingsForm();
        ns.checkThatNewSavingsFormOpened();
        ns.openNewSavingsAccount();
    }
}
