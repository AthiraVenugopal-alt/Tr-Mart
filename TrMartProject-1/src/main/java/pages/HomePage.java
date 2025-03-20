package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
public WebDriver driver;
public HomePage (WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(xpath="//img[@class='img-circle']") private WebElement adminDropDown;
@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") private WebElement logOut;
@FindBy(xpath="//p[text()='Sign in to start your session']") private WebElement startSession;
@FindBy(xpath="//p[text()='Sub Category']") private WebElement subCategory;
@FindBy(xpath = "//p[text()='Manage News']")private WebElement manageNews;
@FindBy(xpath = "//p[contains(text(),' Admin')]")private WebElement adminUsers;

public HomePage clickOnAdminButton()
{
	adminDropDown.click();
	return this;

}
public LoginPage clickOnTheLogoutButton()
{
	logOut.click();	
	return new LoginPage(driver);
}
 
public SubcategoryPage  clickOnSubcategoryButton()
{
	subCategory.click();
	return new SubcategoryPage (driver);
	
}
public ManageNewsPage  clickOnManageNewsButton() 
{
	manageNews.click();
	return new ManageNewsPage(driver);
}


public AdminUserPage clickOnAdminUsersButton() 
{
	adminUsers.click();
	return new AdminUserPage(driver);
}
public boolean isStartSessionTitleDisplayed()
{
	return startSession.isDisplayed();
}

}





