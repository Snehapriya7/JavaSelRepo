package TrySelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class Highlighter {

	public static void main(String[] args) 
	{
	 WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/signup");
	 WebElement username =driver.findElement(By.id("name"));
		Utility.highLightElement(driver, username);
		username.sendKeys("SnehaPriya");
	

	}

}
