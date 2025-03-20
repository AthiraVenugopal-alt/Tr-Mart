package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCourse.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority = 1, description = "Verification of login with valid username and valid password", groups = {"smoke" }, retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidNameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField()
				.enterSigninButtonField();
		boolean isDashboardDisplayed = login.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.VALIDCREDENTIALERROR);

	}

	@Test(priority = 2, description = "Verification of login with Invalid username and valid password", groups = {"smoke" })
	public void verifyUserLoginWithInvalidNameandValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField()
				.enterSigninButtonField();

		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDCREDENTIALERROR);

	}

	@Test(priority = 3, description = "Verification of login with valid username and Invalid password")

	public void verifyUserLoginWithValidUserNameInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField()
				.enterSigninButtonField();

		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDPASSWORDERROR);

	}

	@Test(priority=4,description="Verification of login with Invalid username and Invalid password", dataProvider= "loginProvider")
public void verifyUserLoginWithInvalidUserNameInvalidPassword(String username,String password) throws IOException
{
		//String username=ExcelUtility.readStringData(4, 0, "LoginPage");
		//String password=ExcelUtility.readStringData(4, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField().enterSigninButtonField();
		
		boolean isTitleDisplayed=login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDUSERNAMEERROR);
	}
	

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() 
	{
		return new Object[][] 
		{ new Object[] { "admin", "admin" },
		 new Object[] { "admin", "ami" },
		 new Object[] { "test", "admin" }, 
		 new Object[] { "amin", "anm" } };
	}
}
