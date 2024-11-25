package JavaPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interview_try {

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
	    List<WebElement> links =driver.findElements(By.xpath("//div[@class='social-btns']//a"));
	    for(int i=0;i<links.size();i++)
           {
        	   links.get(0).click();
        	   driver.navigate().back();
            	 
	
           }


	}

}
