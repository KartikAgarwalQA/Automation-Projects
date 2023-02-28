package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.RegistrationPage;

public class TC_03_LoginTest extends BaseClass
{

	@Test(groups= {"Sanity","Master"})
	void test_Login()
	{
		logger.info("*********Starting TC_03_LoginTest*********");
		
		RegistrationPage rp= new RegistrationPage(driver);
		logger.info("*********Entering login details *********");
		
		rp.enterEmail(rb.getString("email"));
		rp.enterPass(rb.getString("password"));
		rp.clickLoginbtn();
		
		String actmsg=rp.getConfirmationmsg_Reg();
		String expmsg="Hello qaKartik (not qaKartik? Sign out)";
		
		Assert.assertEquals(actmsg, expmsg);
		
		logger.info("*********Ending TC_03_LoginTest*********");
		
		
		
	}
	
	
}
