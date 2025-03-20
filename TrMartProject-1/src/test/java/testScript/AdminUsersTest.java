package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCourse.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base 
{
	@Test(priority = 1, description = "verification of user can enter new  admin users informations by clicking New button")
	public void verifyWhetherUserIsAbleToAddNewUserToTheUsersList() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();
		HomePage home;
		home = login.enterSigninButtonField();

		AdminUserPage admin;
		admin = home.clickOnAdminUsersButton();
		admin.clickOnManageUsersButton().clickOnNewButton();
		// String newUsername = ExcelUtility.readStringData(1, 0, "AdminUserPage");
		// String newPassword = ExcelUtility.readStringData(1, 1, "AdminUserPage");
		FakerUtility faker = new FakerUtility();
		String newUsername = faker.createRandomUsername();
		String newPassword = faker.createRandomPassword();

		String newUserType = ExcelUtility.readStringData(1, 2, "AdminUserPage");
		admin.enterNewUsernameOnUsernameField(newUsername).enterNewPasswordOnPasswordField(newPassword)
				. selectNewUserTypeOnUserTypeField(newUserType).clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = admin.getTextFromAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.USERCREATIONERROR);
	}

	@Test(priority = 2, description = "verification of user can refresh AdminUsers page by clicking Reset button")

	public void verifyUserIsAbleToRefreshNewlyAddedUserPageUsingTheResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();
		HomePage home;
		home = login.enterSigninButtonField();

		AdminUserPage admin;
		admin = home.clickOnAdminUsersButton();

		// AdminUserPage admin = new AdminUserPage(driver);
		// admin.clickOnAdminUsersButton();
		admin.clickOnManageUsersButton().clickOnResetButton();
		String expectedResult = "Admin Users";
		String actualResult = admin.getTextFromRefreshUserDisplayed();
		Assert.assertEquals(actualResult, expectedResult, Messages.USERREFRESHPAGEERROR);
	}

	@Test(priority = 3, description = "verification of user can search admin users in AdminUsers list by clicking Search button")
	public void verifyUserIsAbleToSearchNewlyAddedUsersInTheNewlyAddedUsersList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();
		HomePage home;
		home = login.enterSigninButtonField();

		AdminUserPage admin;
		admin = home.clickOnAdminUsersButton();

		// AdminUserPage admin = new AdminUserPage(driver);
		// admin.clickOnAdminUsersButton();
		String searchUsername = ExcelUtility.readStringData(1, 4, "AdminUserPage");
		String searchUserType = ExcelUtility.readStringData(1, 5, "AdminUserPage");
		admin.clickOnManageUsersButton().clickOnSearchButton().enterUsernameOnUsernameFieldOfSearchPage(searchUsername)
				.selectUserTypeOnUserTypeFieldOfSearchPage(searchUserType).clickOnSearchButtonInSearchPage();

		boolean issearchDisplayed = admin.isSearchAUserIsDisplayed();
		Assert.assertTrue(issearchDisplayed, Messages.USERSEARCHPAGEERROR);

	}
}
