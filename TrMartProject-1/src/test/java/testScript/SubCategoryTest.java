package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationCourse.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.SubcategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base
{
	@Test(description = "Verify whether the user can add new item in the Sub category list using New Button")
	public void addNewItemToSubcategoryList() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();
		HomePage home;
		home=login.enterSigninButtonField();
		SubcategoryPage  subCategory = home.clickOnSubcategoryButton();
		
		//SubcategoryPage page= new SubcategoryPage (driver);
				//page.clickOnSubcategoryButton();
		String category=ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		String subcategory=ExcelUtility.readStringData(1, 1, "SubCategoryPage");
		String image=ExcelUtility.readStringData(1, 2, "SubCategoryPage");
		 subCategory.clickOnNewButton().selectCategoryOnSubCategoryPage(category).selectSubCategoryOnSubCategoryPage(subcategory).
				selectImageOnSubCategorypage(image).saveOnSubCategorypage();
				
				String expectedResult = "Alert!";
				String actualResult =subCategory.getTextFromAlert();
				Assert.assertEquals(actualResult, expectedResult, Messages.SUBCATEGORYCREATIONERROR);
		 
}
	@Test(description = "Verify whether the user can search a item in the Sub Category list using Search Button")
	public void searchItemsInTheSubCategoryList() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();
		
		
		HomePage home;
		home = login.enterSigninButtonField();
		SubcategoryPage  subCategory= home.clickOnSubcategoryButton();

		
		String category=ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		String subcategory=ExcelUtility.readStringData(1, 1, "SubCategoryPage");
		subCategory.searchButtonOnSubCategoryPage().selectCategory1OnSubcategoryPage(category).
		             selectSubCategory1OnSubCategoryPage(subcategory).selectSearchButtonInSubcategoryPage();
		
		boolean issearchDisplayed =subCategory.isSearchSubcategoryIsDisplayed();
		Assert.assertTrue(issearchDisplayed, Messages.SUBCATEGORYSEARCHPAGEERROR);
		
		}
	
	
	
	@Test(description = "Verify whether the user can refresh the Sub Category list using Reset Button")
	public void resetPageUsingResetButton() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserField(username).enterPasswordOnUserField(password).enterRememberMeCheckBoxField();
		HomePage home;
		home = login.enterSigninButtonField();
		SubcategoryPage  subCategory= home.clickOnSubcategoryButton();
		
	    subCategory.clickOnResetButtonInSubcategoryPage();
		
		String expectedResult = "List Sub Categories";
		String actualResult =  subCategory.getTextFromRefreshNewsDisplayed();
		Assert.assertEquals(actualResult, expectedResult, Messages.SUBCATEGORYREFRESHPAGEERROR);
	}
	}

	
