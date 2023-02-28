package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountDashboardPage extends BasePage
{

	//constructor
	public MyAccountDashboardPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Elements
	@FindBy(xpath="//a[normalize-space()='Dashboard']")
	WebElement dshbrdbtn;
	
	@FindBy(xpath="//a[normalize-space()='Sign out']")
	WebElement sgnoutbtn;
	
	//Action methods
	public boolean checkDashoardbtn()
	{
		boolean status = dshbrdbtn.isDisplayed();
		return status;
		
	}
	
	public void ClickSignout()
	{
		sgnoutbtn.click();
	}
	
}
