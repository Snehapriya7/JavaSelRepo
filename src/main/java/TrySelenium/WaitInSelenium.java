package TrySelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitInSelenium {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		//Timeouts time=driver.manage().timeouts();
		//time.pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		driver.quit(); 

	}

}
