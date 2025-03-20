package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubcategoryPage 
{
	public WebDriver driver;
	public SubcategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//a[text()=' New']") private WebElement newButton1;
	@FindBy(xpath = "//select[@id='cat_id']") private WebElement categorySelection;
	@FindBy(xpath = "//input[@id='subcategory']") private WebElement subCategorySelection;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement imageSelection;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	
	@FindBy(xpath = "//a[text()=' Search']") private WebElement searchBar;
	@FindBy(xpath = "//select[@id='un']")  private WebElement categorySelection1;
	@FindBy(xpath = "//input[@name='ut']") private WebElement subCategorySelection1;
	@FindBy(xpath = "//button[@name='Search']")private WebElement searchButton;
	
	@FindBy(xpath = "//a[text()=' Reset']") private WebElement resetButton;
	
	@FindBy(xpath = "//h5 [text()=' Alert!']") private WebElement newSubCategoryAlert;
	
	@FindBy(xpath = "//td[text()='Sports Toy Car2']") private WebElement searchSubcategoryIsDisplayed;
	@FindBy(xpath = "//h4[text()='List Sub Categories']") private WebElement refreshSubCategoryDisplayed;
	
	//public SubcategoryPage  clickOnSubcategoryButton()
	//{
		//subCategory.click();
		//return this;
	//}
	public SubcategoryPage  clickOnNewButton()
	{
		newButton1.click();
		return this;
		
	}
	public SubcategoryPage  selectCategoryOnSubCategoryPage(String category)
	{
		Select select2 = new Select(categorySelection);
		select2.selectByVisibleText(category);
		return this;
		
	}
	public SubcategoryPage  selectSubCategoryOnSubCategoryPage(String subCategory2)
	{
		subCategorySelection.sendKeys(subCategory2);
		return this;
	}
	public SubcategoryPage  selectImageOnSubCategorypage(String image)
	{
		imageSelection.sendKeys(image);
		return this;
	}
	public SubcategoryPage  saveOnSubCategorypage()
	{
		saveButton.click();
		return this;
	}
	public SubcategoryPage  searchButtonOnSubCategoryPage()
	{
		searchBar.click();
		return this ;
	}
	public SubcategoryPage  selectCategory1OnSubcategoryPage(String selection)
	{
		Select select=new Select(categorySelection1);
		select.selectByVisibleText(selection);
		return this;
	}
	public SubcategoryPage  selectSubCategory1OnSubCategoryPage(String subCategory3)
	{
		subCategorySelection1.sendKeys(subCategory3);
		return this ;
	}
	public SubcategoryPage  selectSearchButtonInSubcategoryPage()
	{
		searchButton.click();
		return this;
	}
	public SubcategoryPage clickOnResetButtonInSubcategoryPage()
	{
		resetButton.click();
		return this;
	}
	public String getTextFromAlert() 
	{
		return newSubCategoryAlert.getText();
	}

	public boolean isSearchSubcategoryIsDisplayed()
	{
		return searchSubcategoryIsDisplayed.isDisplayed();
	}
	public String getTextFromRefreshNewsDisplayed() 
	{
		return refreshSubCategoryDisplayed.getText();
	}
	
	
	
	
	
	

	
	
	
}