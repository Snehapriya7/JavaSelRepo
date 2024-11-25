package TrySelenium;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import helper.Utility;

public class FluentWaitExample
{

	public static void main(String[] args)
	{
		WebDriver driver=Utility.startBrowser("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
			
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofMillis(200))
			       .ignoring(NoSuchElementException.class);

			   wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver)
			     {
			    	 WebElement element =driver.findElement(By.xpath("//p[@id='demo']"));
			    	 String text= element.getText();
			    	 if(text.contains("WebDriver"))
			    	 {
			    		 System.out.println("Found Text");
			    		 return element;
			    	 }
			    	 else {
			    		 System.out.println("Waiting for text-Current text value is "+text);
						return null;
			    	 }   
			     }
			   });
		

	}

}
