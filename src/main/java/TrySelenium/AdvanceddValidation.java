package TrySelenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdvanceddValidation 
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/signup");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement dd=driver.findElement(By.id("state"));		
		Select state=new Select(dd);
		List<WebElement> allStateValues=state.getOptions();
		System.out.println(allStateValues.size());
		
		List<String> expectedStates=Arrays.asList("Karnataka","Goa");
		boolean allstatus=true;
		for(String stateValues:expectedStates)
		{ 
			boolean status=false;
			
			for(WebElement ele:allStateValues)
			{
				String text=ele.getText();
				if(text.contains(stateValues))
				{
					status=true;
					break;
				}
				else 
				{
					status=false;
				}
			}
			if(!status)
			{  
				System.out.println("Could not find " +stateValues);
				allstatus=false;
			}
		}
		if(allstatus)
		{
			System.out.println("All States found=Validation Pass");
		}
		else
		{
			System.out.println("Could not find States-Validation Fail");
		}
		
		driver.quit();

	}

}
