package TrySelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Utility;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		
		WebDriver driver=Utility.startBrowser("https://www.selenium.dev/documentation/webdriver/waits/#explicit-waits");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		boolean status =wait.until(ExpectedConditions.titleContains("Selenium"));
		if(status)
		{
			System.out.println("Found");
		}
		
		
		
	}

}
