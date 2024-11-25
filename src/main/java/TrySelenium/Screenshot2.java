package TrySelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import helper.Utility;

public class Screenshot2 {

	public static void main(String[] args) {
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		File src= driver.findElement(By.className("submit-btn")).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./Screenshots/Screenshot_"+Utility.getCurrentDateTime()+".png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Screenshot Failed "+e.getMessage());
		}
		driver.quit();


		
	

	}

}
