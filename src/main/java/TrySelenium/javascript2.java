package TrySelenium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;


public class javascript2 {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://login.yahoo.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement email= driver.findElement(By.id("login-username"));
	    WebElement checkbox=driver.findElement(By.id("persistent"));
	    
	    js.executeScript("arguments[0].value=arguments[1]",email,"sneha@yahoo.com");
	    js.executeScript("arguments[0].click()",checkbox);
	    js.executeScript("document.body.style.zoom='75%'");
	    
	    
		/*instead of the above can script as below too:
		js.executeScript("arguments[0].value=arguments[1]",driver.findElement(By.id("login-username")), "sneha@yahoo.com");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("persistent")));
		js.executeScript("document.body.style.zoom='75%'");
		*/
	
	}

}
