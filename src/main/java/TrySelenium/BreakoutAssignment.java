package TrySelenium;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker;
public class BreakoutAssignment 
{
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		System.out.println("Validating on Chrome"+'\n');
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("New user? Signup")).click();
		String s=driver.getCurrentUrl();
		if(s.contains("signup"))
		    System.out.println("URL validated as it contains text signup");
		else 
			System.out.println("Please use the correct URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean b=driver.findElement(By.xpath("//button[text()='Sign up']")).isEnabled();
		if(!b) 
			System.out.println("Sign up button is disabled");
		else 
			System.out.println("Sign up is enabled. Please check as it should be disabled when form is not filled");
	
		Faker fake=new Faker();
		String name=fake.name().fullName();
		String mail=fake.internet().emailAddress();
		String pwd=fake.internet().password();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		String value=driver.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
		if(value.equalsIgnoreCase("Sneha"))
			System.out.println("Entered name is correct");
		else
			System.out.println("Enter a correct name");
		
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(mail);
		String email=driver.findElement(By.xpath("//input[@placeholder='Email']")).getAttribute("value");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		String password=driver.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("value");
		
		driver.findElement(By.xpath("//label[text()='Selenium']")).click();
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		
		Select state=new Select(driver.findElement(By.id("state")));
		state.selectByVisibleText("Gujarat");
		
		Select hobbies=new Select(driver.findElement(By.id("hobbies")));
		hobbies.selectByVisibleText("Playing");
		hobbies.selectByVisibleText("Dancing");
		
		if(driver.findElement(By.xpath("//option[text()='Dancing']")).isSelected())
		{
			System.out.println("Dancing selected");
		}
	
		
	    b=driver.findElement(By.xpath("//button[text()='Sign up']")).isEnabled();
		
		if(b) 
		{	
			System.out.println("Sign up button is enabled");
			driver.findElement(By.xpath("//button[text()='Sign up']")).click();
		}
		else 
			System.out.println("Sign up is disabled. Please fill the form");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();	
	
	}
	
}
