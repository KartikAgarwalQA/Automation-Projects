package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	//Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath="//a[normalize-space()='My Account']")
	WebElement myacnt;
	
	@FindBy(xpath="//a[normalize-space()='Shop']")
	WebElement shp;
	
	
	//Action methods
	public void clickMyAccount()
	{
		myacnt.click();
	}
	
	public void clickShop()
	{
		shp.click();
	}
}
