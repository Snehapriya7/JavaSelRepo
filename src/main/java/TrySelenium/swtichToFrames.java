package TrySelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class swtichToFrames {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=Utility.startBrowser("Chrome","https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String mainwindow=driver.getWindowHandle();
	    int framesize=driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Number of iframes " +framesize);
		driver.findElement(By.xpath("//span[text()='Account']")).click();
		
		driver.findElement(By.xpath("//span[text()='Login/ Sign Up']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		//Get the number of all iframes on the redbus page
		framesize=driver.findElements(By.tagName("iframe")).size();
	    System.out.println("Number of iframes " +framesize);
	    
	    //find the particular frame
	    WebElement signinFrame =driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
	    driver.switchTo().frame(signinFrame);
	    driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys("7890023580");
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    WebElement signGoogleFrame =driver.findElement(By.xpath("//iframe[@title='Sign in with Google Button']"));
	   // WebElement signGoogleFrame =driver.findElement(By.xpath("//iframe[@id='gsi_109312_371692']"));
	    driver.switchTo().frame(signGoogleFrame);
	    driver.findElement(By.xpath("//span[@class='nsm7Bb-HzV7m-LgbsSe-BPrWId']")).click();
	   
	    
	    Set<String> win=driver.getWindowHandles();
	    for(String w:win)
	    {   
	      driver.switchTo().window(w);
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	      String title=driver.getTitle();
	      System.out.println("Window "+title);
	      if(title.contains("Google"))
	      {
	    	 
	    	  System.out.println("Closing Google window");
	    	  driver.close();
	      }
	      
	    }    
	    driver.switchTo().window(mainwindow);
	    driver.switchTo().frame(signinFrame);
	    
	    System.out.println("Switched to main window and sign in frame");
	    
	    Thread.sleep(5000);
	    WebElement captcha =driver.findElement(By.xpath("(//iframe[@title='reCAPTCHA'])[1]"));
	    driver.switchTo().frame(captcha);
	    driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
	     
	    driver.switchTo().parentFrame();
	    //signinFrame.click();
	    
	    
	    driver.findElement(By.xpath("//div[@id='otp-container']")).click();
	    

	
	}
}
