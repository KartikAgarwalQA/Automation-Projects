package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyAccountDashboardPage;
import pageObjects.RegistrationPage;
import utilities.DataProviders;

public class TC_04_LoginTestDDT extends BaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	void test_LoginDDT(String lgnemail,String lgnpass , String exp)
	{
		logger.info("********Starting TC_04_LoginTestDDT******");
		
		try {
		RegistrationPage rp= new RegistrationPage(driver);
		logger.info("*********Entering login details *********");
		
		rp.enterEmail(lgnemail);
		rp.enterPass(lgnpass);
		rp.clickLoginbtn();
		MyAccountDashboardPage dp=new MyAccountDashboardPage(driver);
		
		boolean trgpage=rp.isMyAccountPageexist();
		
		if(exp.equals("Valid"))
		{
		
			if(trgpage==true)
			{
				dp.ClickSignout();
				Assert.assertTrue(true);
				rp.clearEmail();
				rp.clearPass();
				
			}
			else
			{
				Assert.fail();
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(trgpage==true)
			{
				dp.ClickSignout();
				Assert.assertTrue(false);
				rp.clearEmail();
				rp.clearPass();
			}
			else
			{
				rp.clearEmail();
				rp.clearPass();
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
	
		
		
		logger.info("*********Ending TC_03_LoginTest*********");
		
		
		
		
	}
	
	
	
	
}
