package TrySelenium;

import java.time.Duration;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.Utility;



public class CreateCategoryAssignment {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/");
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.xpath("//a[text()='New user? Signup']")).click();
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='interest-div']"));
		if(list.size()>5)
		{
			System.out.println("Checkboxes are greater than 5");
			
		}
		else 
		{
			System.out.println("Checkboxes are equal to or less than 5");
		}
		driver.navigate().back();

		//Login to the application
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		String parent = driver.getWindowHandle();

		//Mouse hover to Manage option on the top
		Actions actions=new Actions(driver);
		WebElement text =driver.findElement(By.xpath("//span[text()='Manage']"));
		actions.moveToElement(text).perform();
		driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
		
		Set<String> wins =driver.getWindowHandles();
		
		for(String window:wins)
		{
		if(!parent.equals(window))
		{
			driver.switchTo().window(window);
			System.out.println("You are on New Tab window-->"+driver.getCurrentUrl());
		}
		}
		
		//Adding a new Category
		List<WebElement> l= driver.findElements(By.xpath("//tr"));
		driver.findElement(By.xpath("//button[text()='Add New Category ']")).click();
		
		Alert a= driver.switchTo().alert();
		String inputText="Azure Devops10";
		a.sendKeys(inputText);
		a.accept();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tr"), l.size()+1));
		
		//Verify if the added category is present on the table
		boolean catText= driver.findElement(By.xpath("//tbody/tr/td[text()='Azure Devops10']")).isDisplayed();
		if(catText)
		{
			System.out.println(inputText+" is on the list");
		}
		else {
			System.out.println(inputText+ " is not on the list");
		}
		
		//Sign out in the child window and close it. Switch to parent window and go to signup page
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.xpath("//a[text()='New user? Signup']")).click();
		
		//Verify if the added category is included in the check boxes' list
		List<WebElement> listCheckboxes=driver.findElements(By.xpath("//label[@class='interest']"));
		for(WebElement checkbox:listCheckboxes)
		{
			if(inputText.equals(checkbox.getText()))
			{
				System.out.println(inputText+ " is present as a checkbox in the Signup window");
			}
		}
		
		//If present navigate back to the login page
		driver.navigate().back();
		
		//Login to the application
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		
		//Mouse hover to Manage option on the top
		Actions action=new Actions(driver);
		WebElement text1 =driver.findElement(By.xpath("//span[text()='Manage']"));
		action.moveToElement(text1).perform();
		driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
		
	    Set<String> win =driver.getWindowHandles();
		for(String window:win)
		{
		 if(!parent.equals(window))
		 {
			driver.switchTo().window(window);
			System.out.println("You are on New Tab window-->"+driver.getCurrentUrl());
		 }
		}
		
		//Wait until the table is loaded and scroll down to view all the rows
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[1]")));
	    List<WebElement> rows= driver.findElements(By.xpath("//tbody/tr"));
		  int z=rows.size();
	       JavascriptExecutor js=(JavascriptExecutor)driver;
		 WebElement e=driver.findElement(By.xpath("//tbody/tr["+ z +"]"));
		 js.executeScript("arguments[0].scrollIntoView(true);",e);
		 
	   //Verify if the added category is present and if present delete the same
	    for(int i=1;i<=rows.size();i++)
		{
			     
		       	 WebElement cell= driver.findElement(By.xpath("//tbody/tr["+ i +"]/td[1]"));
	 	    	 String celltext=cell.getText();
		    	 if(celltext.equals(inputText))
		    	 {	    	
		    		 driver.findElement(By.xpath("//tbody/tr[" + i +"]/td[2]/button[text()='Delete ']")).click();		    
		    		 driver.findElement(By.xpath("//button[text()='Delete']")).click();
		    		 break;
		    	 } 
	 	
		}
	    
	    //Validating if the deletion is successful
	 	boolean del=false;
		for(int i=1;i<=rows.size();i++)
		{
		  String s=	driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();
		  if(!s.equals(inputText))
		  {
			  del=true;
		  }
		  	
		}
	     if(del)
	     {
	    	 System.out.println(inputText+ " Deleted");
	     }
	     else {
			System.out.println(inputText+ "Not Deleted");
		}
			
		//Signout and go to signup page to check if the new category got deleted from the check boxes' list
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.xpath("//a[text()='New user? Signup']")).click();
		
		boolean check=false;
		List<WebElement> listCheckboxes1=driver.findElements(By.xpath("//label[@class='interest']"));
		for(WebElement checkbox:listCheckboxes1)
		{
			if(!inputText.equals(checkbox.getText()))
			{
				check=true;
			}
		}
		if(check)
		{
			System.out.println(inputText+ " is not present as a checkbox in the Signup window");
		}
		
	}

}
