package TrySelenium;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Utility;

public class ExplicitWaitExample3 
{
	public static void main(String[] args)
	{
	  WebDriver driver=Utility.startBrowser("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
      driver.findElement(By.xpath("//input[@value='Show me']")).click();
      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
      WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("passnew")));
      element.sendKeys("selenium");
	}
	

}
