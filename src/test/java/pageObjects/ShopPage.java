package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage

{

	//constructor
	public ShopPage(WebDriver driver)
	{
		super(driver);
	}
	
	//WebElements
	
	@FindBy(xpath="//div[@class='ui-slider-range ui-corner-all ui-widget-header']/following-sibling::span[2]")
	WebElement maxslider;
	
	@FindBy(xpath="//button[normalize-space()='Filter']")
	WebElement fltrbtn;
	
	@FindBy(xpath="//span[@class='to']")
	WebElement maxprice;
	
	//Action methods
	
	/*
	public void dragfilter()
	{
		

		//int width = maxslider.getSize().getWidth();
		//int xOffset = width - 1;
		
		
		Actions act=new Actions(driver);
		
		System.out.println("Current location of max slider:"+maxslider.getLocation());
		System.out.println(maxprice.getText());
		act.dragAndDropBy(maxslider, left: 0%; width: 85.7143%;, 290).perform();
		
		
		String maxPriceText = maxprice.getText();
		if (maxPriceText.equals("450")) {
		    System.out.println("Slider moved to right end successfully");
		} else {
		    System.out.println("Slider movement failed");
		}

		
		
		
		
	}
	*/
	
	
	public void clickfilterbtn()
	{
		fltrbtn.click();
	}
	
	
	
	
	
}
