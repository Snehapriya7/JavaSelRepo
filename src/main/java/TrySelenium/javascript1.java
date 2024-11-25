package TrySelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import helper.Utility;

public class javascript1 {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://login.yahoo.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("document.getElementById(\"login-username\").value=\"Selenium@yahoo.com\"");
		js.executeScript("document.getElementById('persistent').click()");
		
	
		
	}

}
