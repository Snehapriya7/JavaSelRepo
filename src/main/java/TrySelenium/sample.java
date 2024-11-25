package TrySelenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class sample {

	public static void main(String[] args) 
	{
		ChromeDriver driver=new ChromeDriver();
	    driver.get("https://www.selenium.dev/");
	    String title=driver.getTitle();
	    if(title.equalsIgnoreCase("Selenium"))
	    	System.out.println("Title is same as Selenium");
	    else
	    	System.out.println("Title is not same as Selenium");
		
		FirefoxDriver driver1=new FirefoxDriver();
		driver1.get("https://www.selenium.dev/");
	    title=driver1.getTitle();
	    if(title.equalsIgnoreCase("Selenium"))
	    	System.out.println("Title is same as Selenium");
	    else
	    	System.out.println("Title is not same as Selenium");
		
		
		EdgeDriver driver2=new EdgeDriver();
		driver2.get("https://www.selenium.dev/");
	    title=driver2.getTitle();
	    if(title.equalsIgnoreCase("Selenium"))
	    	System.out.println("Title is same as Selenium");
	    else
	    	System.out.println("Title is not same as Selenium");

		//SafariDriver driver3=new SafariDriver();
		//driver3.get("https://www.selenium.dev/");

	}

}
