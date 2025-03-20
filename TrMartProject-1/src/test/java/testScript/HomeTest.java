package testScript;


import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationCourse.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base
{
	@Test
	(description = "Verification of whether the user is able to use the Logout functionality after LogIn",retryAnalyzer = retry.Retry.class)
	
	public void verifyUserLogoutFromPage() throws IOException
	{
		HomePage home;
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();
		
		home = login.enterSigninButtonField();
		home.clickOnAdminButton();
		login=home.clickOnTheLogoutButton();
		
			boolean isStartSessionDisplayed=home.isStartSessionTitleDisplayed();
			Assert.assertTrue(isStartSessionDisplayed, "User is unable to logout from the home page");
	}
	

}
