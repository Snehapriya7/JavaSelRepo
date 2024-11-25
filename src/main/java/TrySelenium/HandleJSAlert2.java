package TrySelenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import helper.Utility;


public class HandleJSAlert2 {

	public static void main(String[] args) 
	{
		
		WebDriver driver=Utility.startBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();

		
		String text=Utility.acceptAlert(driver);
		System.out.println("Alert text is "+text);
		driver.findElement(By.id("password")).sendKeys("mukesh");

		if(text.contains("Please enter a valid user name"))
		{
			System.out.println("Verified Alert Text");
		}
		else 
		{
			System.out.println("Alert Text Mismatched");
		}
		//driver.quit();
	}

}
