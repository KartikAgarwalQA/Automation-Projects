package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountDashboardPage;
import pageObjects.RegistrationPage;

public class TC_01_AccountRegistrationTest extends BaseClass
{

	@Test(groups= {"Regression","Master"})
	 void test_account_Registration() throws InterruptedException
	{
		logger.debug("Application logs............");
		logger.info("*********Starting TC_01_AccountRegistrationTest*********");
		/*
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		
			//driver.switchTo().frame("aswift_3");
			//driver.switchTo().frame("ad_iframe");
		logger.info("Waiting for ad popup");
			WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(5));
			mywait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("aswift_3"));
			
			//WebElement innerframe = driver.findElement(By.id("ad_iframe"));
			
			mywait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ad_iframe"));
			
			//driver.switchTo().frame("aswift_3");
			//driver.switchTo().frame(innerframe);
			
			driver.findElement(By.id("dismiss-button")).click();
			driver.switchTo().defaultContent();
	
			logger.info("Ad popup found and clicked on close");
		
		//driver.switchTo().defaultContent();
		
		
		//Thread.sleep(2000);
		*/
		RegistrationPage rp=new RegistrationPage(driver);
		rp.enterEmail_Reg(AlphaNumeric()+"@gmail.com");
		
		logger.info("Entered Email");
		
		rp.enterPass_Reg(PasswordGen());
		
		
		logger.info("Entered Pass");
		
		rp.clickRegister();
		logger.info("Clicked Register");
		
		MyAccountDashboardPage mcd= new MyAccountDashboardPage(driver);
		boolean status =mcd.checkDashoardbtn();
		
		Assert.assertEquals(status, true);
		
		
		
		
		
		logger.info("*********Finished TC_01_AccountRegistrationTest*********");
		
		
		
		
	}
	
	
	
}
