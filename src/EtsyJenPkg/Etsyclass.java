package EtsyJenPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsyclass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Chrome browser is launched");
		
		//launched etsy site
		driver.get("https://www.etsy.com/");		
		System.out.println("User enters etsy.com in the url tsting"); 
		
		//click on Sign-in button
		driver.findElement(By.xpath("//*[@id='gnav-header-inner']/div[4]/nav/ul/li[1]/button")).click();
		Thread.sleep(3000);
		System.out.println("The user clicks on the signin button");
		
		//Click Register button
		driver.findElement(By.xpath("//*[@id='join-neu-form']/div[1]/div/div[1]/div/button")).click();
		Thread.sleep(3000);
		System.out.println("User clicks on register button on signin page"); 
		
		//Enter email, user firstname and pwd
		String firstname;
		
		driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys("Parmeson123@yahoo.com");
		
		WebElement name = driver.findElement(By.xpath("//input[@id='join_neu_first_name_field']"));
		name.sendKeys("Parmeson cheese");
		firstname = name.getAttribute("value");  
		System.out.println("First name is:" +firstname);
		
		driver.findElement(By.xpath("//input[@id='join_neu_password_field']")).sendKeys("Pcheese123!");		
		System.out.println("The user enters credentials");
		
		//Click on Register button
		driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
		Thread.sleep(3000);
		System.out.println("The user should be landing on home page");  
		
		//home page displayed and verify the title
		String title = driver.getTitle();
		System.out.println("The title of the page:" + title);
				
		if(title.equals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone"))

		{
			System.out.println("You are on Etsy.com home page");
		}  
	
		//Verify profile is created
		WebElement profile = driver.findElement(By.xpath("//span[@class='text-link-copy'][contains(text(),'You')]"));
		String profile1 =profile.getText();
		System.out.println("Signin changed to: " +profile1);
		
		if(profile1.equals("You"))
		{
			System.out.println("User Profile is created");
		} 
		//Click on dropdwon and select the "you"
		driver.findElement(By.xpath("//span[@class='nav-icon nav-icon-image nav-icon-circle']")).click();
		Thread.sleep(3000);
		System.out.println("User clicks on the dropdown arrow to see the profile"); 
		//verify the profile
		WebElement name1 = driver.findElement(By.xpath("//p[@class='name']"));
		String profilename = name1.getText();
		System.out.println("Profile name is: " +profilename); 
		
		if(firstname.equals(profilename))
		{
			System.out.println("Passed");
		}
		
		System.out.println("Username is displayed as the profile name"); 
		System.out.println("Account creation is successful!!");
		
		//close the browser
		driver.quit();
	}
		
}
