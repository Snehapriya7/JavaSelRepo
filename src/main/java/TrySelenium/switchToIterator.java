

package TrySelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchToIterator 
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String parentWindow=driver.getWindowHandle();
		System.out.println("Parent Window Handle"+parentWindow);
		
		driver.findElement(By.xpath("//div[@id='login_container']//a[contains(@href,'linkedin')]")).click();
		Set <String> allWindows=driver.getWindowHandles();
		
		//Iterator will iterate the values.It returns iterator of String type
		
		Iterator<String> itr=allWindows.iterator();
		

	    while(itr.hasNext())
		{
		 String handle=itr.next();
		 
		 if(!parentWindow.equals(handle))
		  {
			 driver.switchTo().window(handle);
			 if(driver.getTitle().contains("LinkedIn"))
			 {
				 System.out.println("Switched to child window- "+driver.getTitle());
				 driver.close();
			 }
		  }
		 
		}
		
		driver.switchTo().window(parentWindow);
		driver.quit();
	}
}
