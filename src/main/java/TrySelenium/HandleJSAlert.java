package TrySelenium;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleJSAlert 
{
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		Alert alt= driver.switchTo().alert();
		String text=alt.getText();
		System.out.println("Alert text is "+text);
		if(text.contains("Please enter a valid user name"))
		{
			System.out.println("Verified Alert Text");
		}
		else 
		{
			System.out.println("Alert Text Mismatched");
		}
		alt.accept();
		
	}

}
