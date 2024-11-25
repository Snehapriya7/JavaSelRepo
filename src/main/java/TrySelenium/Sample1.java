package TrySelenium;

import org.openqa.selenium.WebDriver;

import helper.Utility;

public class Sample1 {

	public static void main(String[] args)
	{
		WebDriver driver=Utility.startBrowser();
		driver.close();
		
		driver=Utility.startBrowser("https://www.google.com");
	    driver.quit();
	    
	    driver=Utility.startBrowser("Edge", "https://www.gmail.com");
	    driver.quit();
	    
	    driver=Utility.startBrowser("Firefox", "https://www.youtube.com", 50);
	    driver.quit();
	   

	}

}
