package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage
{

	//Constructor
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath="//input[@id='reg_email']")
	WebElement Emailiptbox;
	
	@FindBy(xpath="//input[@id='reg_password']")
	WebElement Passiptbox;
	
	@FindBy(xpath="//input[@name='register']")
	WebElement Registerbtn;
	
	@FindBy(xpath="//p[contains(text(),'Hello')]")
	WebElement cnfrmmsg;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement emaillgn;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passlgn;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginbtn;
	
	//Action methods
	
	public void enterEmail_Reg(String email)
	{
		Emailiptbox.sendKeys(email);
	}
	
	public void enterPass_Reg(String pass)
	{
		Passiptbox.sendKeys(pass);
	}
	
	public void clickRegister()
	{
		Registerbtn.click();
	}
	
	public String getConfirmationmsg_Reg()
	{
		try
		{
		return (cnfrmmsg.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public boolean isMyAccountPageexist()
	{
		try {
		return (cnfrmmsg.isDisplayed());
		}catch(Exception e)
		{
			return (false);
		}
	}
	
	
	//login
	public void enterEmail(String lgnemail)
	{
		emaillgn.sendKeys(lgnemail);
		
	}
	
	public void clearEmail()
	{
		emaillgn.clear();;
		
	}
	
	public void enterPass(String lgnpass)
	{
		passlgn.sendKeys(lgnpass);
	}
	
	public void clearPass()
	{
		passlgn.clear();
		
	}
	
	public void clickLoginbtn()
	{
		loginbtn.click();
	}
}
