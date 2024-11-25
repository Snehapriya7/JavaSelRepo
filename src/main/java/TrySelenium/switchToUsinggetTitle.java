
package TrySelenium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchToUsinggetTitle {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String parentWindow=driver.getWindowHandle();

		List<WebElement> allSocialMediaLinks=driver.findElements(By.xpath("//div[@id='login_container']//div[@class='social-btns']//a"));
		for(WebElement link:allSocialMediaLinks)
		{
			link.click();
			
		}
		Set<String> allWindows=driver.getWindowHandles();
		for(String handle:allWindows) 
		{
			driver.switchTo().window(handle);
			String title=driver.getTitle();
			System.out.println("Title of new tab "+title);
			if(title.contains("LinkedIn"))
			{
				System.out.println("Found desired tab");
				/*
				 * 
				 */
				break;  
			}
			else 
			{
				System.out.println("Still waiting for desired Title-Current Tile is  "+title);
				
			}
		}
		driver.switchTo().window(parentWindow);
	}
}
