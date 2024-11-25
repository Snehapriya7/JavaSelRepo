package TrySelenium;

import java.net.PasswordAuthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginpageAssignment {

	public static void main(String[] args) throws InterruptedException 
	{
		//1.Verifying error message without entering email and password
		WebDriver driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		String error=driver.findElement(By.xpath("//h2[text()='Email and Password is required']")).getText();
		if(!error.equals("Email and Password is required"))
		{
			System.out.println("Wrong error message is being displayed");
		}
		else 
			System.out.println("First error:'Email and Password is required' captured");
		
		driver.quit();
			
		//2.Verifying error message after entering only Email
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://freelance-learn-automation.vercel.app/login");
		driver1.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("Sneha@gmail.com");
		driver1.findElement(By.xpath("//button[text()='Sign in']")).click();
		String error1=driver1.findElement(By.xpath("//h2[text()='Password is required']")).getText();
		if(!error1.equals("Password is required"))
		{
			System.out.println("Wrong error message is being displayed");
		}
		else 
			System.out.println("Second error:'Password is required' captured");
		
		driver1.quit();
		
		//3.Verifying error message after entering only Password	
		WebDriver driver2=new ChromeDriver();
		driver2.get("https://freelance-learn-automation.vercel.app/login");
		driver2.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("snehapriya");
		driver2.findElement(By.xpath("//button[text()='Sign in']")).click();
		String error2=driver2.findElement(By.xpath("//h2[text()='Email is required']")).getText();
		if(!error2.equals("Email is required"))
		{
		   System.out.println("Wrong error message is being displayed");
		}
		else
		   System.out.println("Third error:'Email is required' captured");
		
		driver2.quit();
		
		//4.Verifying error message after entering both user and password but user doesn't exist
		WebDriver driver3=new ChromeDriver();
		driver3.get("https://freelance-learn-automation.vercel.app/login");
		driver3.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("admin89@gmail.com");
		driver3.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("mukesh123");
		driver3.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(1000);
		String error3=driver3.findElement(By.xpath("//h2[@class='errorMessage']")).getText();
		if(!error3.equals("USER Email Doesn't Exist"))
		{
			System.out.println("Wrong error message is being displayed");
		}
		else 
			System.out.println("Fourth error:'User Email Doesn't Exist' captured");
		
		driver3.quit();
		
		
	}

	
}
