package TrySelenium;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.Utility;


public class CreateCourseAssignmnet {

	public static void main(String[] args) 
	{
		WebDriver driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/login");
		
		//Login to the application
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		
		//Mouse hover to Manage option on the top
		Actions actions=new Actions(driver);
		WebElement text =driver.findElement(By.xpath("//span[text()='Manage']"));
		actions.moveToElement(text).perform();
		
		//Click on Manage Courses option
		driver.findElement(By.xpath("//a[text()='Manage Courses']")).click();
		
		//Click on Add New Course button
		driver.findElement(By.xpath("//button[normalize-space()='Add New Course']")).click();
		
		//Fill in the Add New Course details
		driver.findElement(By.id("thumbnail")).sendKeys("C:\\Users\\91789\\OneDrive\\Pictures\\Screenshots\\abc.png");
		
		WebElement name= driver.findElement(By.id("name"));
				name.sendKeys("Selenium With Python");
				String courseName=name.getAttribute("value");
			    
		driver.findElement(By.id("description")).sendKeys("Selenium With Python");
		driver.findElement(By.id("instructorNameId")).sendKeys("Mukesh Otwani");
		driver.findElement(By.id("price")).sendKeys("20000");
		
		//Choose date from Calendar
		driver.findElement(By.xpath("//input[@name='startDate']")).click();
		driver.findElement(By.xpath("//div[text()='13']")).click();
		
		driver.findElement(By.xpath("//input[@name='endDate']")).click();
		WebElement month= driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
		while(!month.getText().contains("January"))
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("document.getElementsByClassName('react-datepicker__navigation-icon react-datepicker__navigation-icon--next')[0].click();");
	    }
		driver.findElement(By.xpath("//div[text()='13']")).click();
		
		driver.findElement(By.xpath("//button[@class='menu-btn']")).click();
		List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='menu-item']"));
		
		for(WebElement list:buttons)
		{
			if(list.getText().equalsIgnoreCase("Selenium"))
			{
				list.click();
				break;
			}
		}
		
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait1.until(ExpectedConditions.textToBe(By.xpath("//tr[1]/td[2]"), courseName));
		
		
		//Verify if the course is added
	    WebElement course= driver.findElement(By.xpath("//tr[1]/td[2]"));
	    if(course.getText().equals(courseName))
	    
	    	System.out.println("Course added successfully");
	    
	    else 
			System.out.println("Course was not added.Try again");
	    
		//Delete the course
	    driver.findElement(By.xpath("//tr[1]/td[12]/button")).click();
	    
	    //Verify if the course is deleted
	    WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(50));
	    WebElement but=driver.findElement(By.xpath("//button[@class='action-btn delete-btn']"));
	    wait2.until(ExpectedConditions.invisibilityOf(but));
	    		
	    String del =driver.findElement(By.xpath("//tr[1]/td[12]")).getText();
	    
	  
	    System.out.println(del);
        if(del.isEmpty())
        {
        	System.out.println("Course deleted");
        }
        else
        	System.out.println("Couldnt delete the course");
        	
				
        //Find the menu and sign out
        driver.findElement(By.xpath("//img[@alt='menu']")).click();
        driver.findElement(By.xpath("//button[text()='Sign out']")).click();
        
	}

}
