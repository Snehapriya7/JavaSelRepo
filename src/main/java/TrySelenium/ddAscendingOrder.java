package TrySelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ddAscendingOrder {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/signup");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement dd=driver.findElement(By.id("state"));		
		Select state=new Select(dd);
		List<WebElement> allSatates=state.getOptions();
		
		List<String> actualList=new ArrayList<String>();
		
		for(WebElement ele: allSatates)
		{
			String stateName=ele.getText();
			actualList.add(stateName);
		}
		List<String> expectedList=new ArrayList<String>();
		expectedList.addAll(actualList);
		Collections.sort(expectedList);
		System.out.println("ActualList"+actualList+'\n'+"ExpectedList"+expectedList);
		if(expectedList.equals(actualList))
		{
			System.out.println("Validation Passed");
		}
		else 
		{
			System.out.println("Validation Fail");
		}
	}

}
