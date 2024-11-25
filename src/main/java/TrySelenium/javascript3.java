package TrySelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class javascript3 {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.tagName("textarea")));
		driver.findElement(By.tagName("textarea")).sendKeys("sneha sample text");
	}

}
