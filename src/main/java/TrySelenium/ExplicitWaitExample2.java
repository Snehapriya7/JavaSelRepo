package TrySelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Utility;

public class ExplicitWaitExample2 {

	public static void main(String[] args)
	{
		WebDriver driver=Utility.startBrowser("https://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
		driver.findElement(By.xpath("//button[normalize-space()='Try it']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));	
		Alert alt=wait.until(ExpectedConditions.alertIsPresent());
		
		if(alt.getText().contains("Welcome"))
			System.out.println("Text Verified");
		else 
			System.out.println("Could not verify the text");
		
		alt.accept();
		driver.quit();
	}

}
