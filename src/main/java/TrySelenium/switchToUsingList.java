
package TrySelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchToUsingList{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String parentWindow=driver.getWindowHandle();
		System.out.println("Parent Window Handle"+parentWindow);
		
		driver.findElement(By.xpath("//div[@id='login_container']//a[contains(@href,'linkedin')]")).click();
		Set <String> allWindows=driver.getWindowHandles();
		
		//Converting set to list so that we can access the values.
		List<String> windowsInList=new ArrayList<String>(allWindows);
		String childWindow=windowsInList.get(1);
		driver.switchTo().window(childWindow);
		
		if(driver.getTitle().contains("LinkedIn"))
		{
			System.out.println("Switched to chid window");
			/*
			 * please perform required tasks on child window
			 */
			
			driver.close();
		}
		
		driver.switchTo().window(parentWindow);
		driver.quit(); 
	}

}
