package testScript;

import static org.testng.AssertJUnit.assertEquals;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCourse.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base 
{
	@Test(description = "Verify whether the user can add new news in the News list using New Button")
	public void createNewNewsInManageNews() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();

		HomePage home;
		home = login.enterSigninButtonField();

		ManageNewsPage manage = home.clickOnManageNewsButton();

		String news = ExcelUtility.readStringData(1, 0, "ManageNewsPage");

		manage.clickOnNewButtonOfManageNewsPage().enterNewNewsOnNewsField(news).clickOnSaveButtonOfNewNewsCreationpage();

		String expectedResult = "Alert!";
		String actualResult = manage.getTextFromAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.MANAGENEWSCREATIONERROR);
	}
@Test(description = "Verify whether the user can search a news in the News list using Search Button")
	public void searchNewsInManageNews() throws IOException
{
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();

		HomePage home;
		home = login.enterSigninButtonField();
        ManageNewsPage manage= home.clickOnManageNewsButton();
		String news = ExcelUtility.readStringData(1, 0, "ManageNewsPage");
		manage.clickOnSearchButtonOfManageNewsPage().enterSearchNewsOnSearchNewsField(news).clickOnSearchButtonOfSearchNewsPage();
		
		boolean issearchDisplayed = manage.isSearchNewsIsDisplayed();
		Assert.assertTrue(issearchDisplayed, Messages.MANAGENEWSSEARCHPAGEERROR);
	}

	@Test(description = "Verify whether the user can refresh the News list using Reset Button")
	public void refreshPageUsingTheResetButton() throws IOException 
	{
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();

		HomePage home;
		home = login.enterSigninButtonField();
        ManageNewsPage manage= home.clickOnManageNewsButton();
		//ManageNewsPage manage = new ManageNewsPage(driver);
		//manage.clickOnManageNewsButton();
		manage.clickOnResetButtonOfManageNewsPage();
		
		String expectedResult = "Manage News";
		String actualResult = manage.getTextFromRefreshNewsDisplayed();
		Assert.assertEquals(actualResult, expectedResult, Messages.MANAGENEWSREFRESHPAGEERROR);

	}

}