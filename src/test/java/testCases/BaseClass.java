package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static WebDriver driver;
	
	public Logger logger; //for logging
	
	public ResourceBundle rb; //for loading config prop
	
	@BeforeClass(groups= {"Regression","Sanity","Master"})
	@Parameters("browser")
	public void setup(String br)
	
	{
		
		
		if(br.equals("chrome"))
		{
			driver =new ChromeDriver();
		}
		
		else if(br.equals("edge"))
		{
			driver =new EdgeDriver();
			
		}
		
		else if(br.equals("firefox"))
		{
			driver =new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		
		logger =LogManager.getLogger(this.getClass()); //Logging data with class name ,i.e Test name	
		
		rb=ResourceBundle.getBundle("config");  //loading config.properties file
		
		driver.get(rb.getString("appURL1"));
		//driver.get("https://practice.automationtesting.in/my-account/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
	}
	
	@AfterClass(groups= {"Regression","Sanity","Master"})
	public void teardown()
	{
		driver.quit();
	}
	
	
	//Random string methods
	public String randomString()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public String randomNumber()
	{
		String generatedString= RandomStringUtils.randomNumeric(10);
		return generatedString;
		
	}
	public String AlphaNumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(4);
		String num= RandomStringUtils.randomNumeric(4);
		
		return (st+num);
	}

	public String PasswordGen()
	{
		String st=RandomStringUtils.randomAlphabetic(4);
		String num= RandomStringUtils.randomNumeric(4);
		
		
		
		return (st+"@"+num);
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}

