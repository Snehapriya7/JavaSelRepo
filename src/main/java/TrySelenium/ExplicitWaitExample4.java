package TrySelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import helper.Utility;

public class ExplicitWaitExample4 
{
	public static void main(String[] args)
	{
	  WebDriver driver=Utility.startBrowser("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
      driver.findElement(By.xpath("//input[@value='Show me']")).click();
      WebElement element =Utility.waitForWebElement(driver, By.id("passnew"));
      element.sendKeys("Selenium");
	}
	

}
