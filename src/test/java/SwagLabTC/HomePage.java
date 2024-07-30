package SwagLabTC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomePage {
	WebDriver driver;
	@BeforeSuite
	public void url() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@Test(priority = 1)
	public void title() {
		WebElement logo = driver.findElement(By.className("login_logo"));
		System.out.println("=================================");
		System.out.println(logo.getText());
		System.out.println("=================================");
		
		WebElement creds = driver.findElement(By.className("login_credentials_wrap-inner"));
		System.out.println(creds.getText());
		System.out.println("=================================");
	}
	
	@Test(priority = 2)
	public void login() {
		
		WebElement un = driver.findElement(By.id("user-name"));
		WebElement ps = driver.findElement(By.id("password"));
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		
		
		un.sendKeys("standard_user");
		ps.sendKeys("secret_sauce");
		loginbtn.click();
		
	}
	
	@Test(priority = 3)
	public void applogo() {
		WebElement logo = driver.findElement(By.className("app_logo"));
		System.out.println(logo.getText());
		System.out.println("=================================");
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
	}


}
