package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath="//input[@name='username']") private WebElement userName;
    @FindBy(xpath="//input[@name='password']") private WebElement password;
    @FindBy(xpath="//label[@for='remember']") private WebElement rememberMeCheckbox;
	@FindBy(xpath="//button[@type='submit']") private WebElement signinButton;
	@FindBy (xpath = "//p[text()='Dashboard']") private WebElement dashboard;
	@FindBy (xpath = "//b[text()='7rmart supermarket']") private WebElement title;
	
	
	public LoginPage enterUsernameOnUserField(String username)
	{
		userName.sendKeys(username);
		return this;
	}
	public LoginPage enterPasswordOnUserField(String password1)
	{
		password.sendKeys(password1);
		return this;
	}
	public LoginPage enterRememberMeCheckBoxField()
	{
		rememberMeCheckbox.click();
		return this;
	}
	public HomePage enterSigninButtonField()
	{
		signinButton.click();
		return new HomePage(driver);
	}
	
		public boolean isDashboardDisplayed()
	{
				return dashboard.isDisplayed();
	}
	
	public boolean isTitleDisplayed()
	{
		return title.isDisplayed();
	}
	public void clickOnCheckbox() {
		// TODO Auto-generated method stub
		
	}
}
