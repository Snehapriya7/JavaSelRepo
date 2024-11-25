package TrySelenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import helper.Utility;

public class screenshot {

	public static void main(String[] args) {
		
		/*
		 * Selenium - TakesScreenshot Interface-(Takes screenshot of browsers)
		 *                      file - File
		 *                      byte[]- Allure Report, Extent Report, BDD Reports
		 *                      base64(string in encrypted format- Allure Report, Extent Report, BDD Reports 
		 * Java-Robot class-(Captures Screenshot of Current screen
		 * 
		 * Third Party Java Libraries
		 * 
		 */
		
		WebDriver driver =Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		TakesScreenshot ts= (TakesScreenshot) driver;
		//keeps the below file in temporary location and once program is exited file will be deleted
	    File src =ts.getScreenshotAs(OutputType.FILE);
	    System.out.println(src.getAbsolutePath());
	    
	    File dest=new File("./Screenshots/Screenshot1.png");
	    try 
	    {
			FileHandler.copy(src,dest);
	    } 
	    catch (IOException e) 
	    {			
		    System.out.println("Screenshot Failed "+e.getMessage());
		}
	    driver.quit();

	}

}
