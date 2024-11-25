package TrySelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import helper.Utility;

public class Screenshot1 {

	public static void main(String[] args) {
		
        WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Utility.captureScreenshots(driver);Utility.captureScreenshots(driver);
        driver.findElement(By.id("email1")).sendKeys("adasdasdad");
        Utility.captureScreenshots(driver);
        driver.findElement(By.id("password1")).sendKeys("wewewewe");
        Utility.captureScreenshots(driver);
        
        driver.quit();
	
	}

}
