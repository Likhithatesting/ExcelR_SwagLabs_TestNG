package SwagLabTC;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	public void url() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@FindBy(id = "user-name") WebElement un;
	@FindBy(id = "password") WebElement ps;
	@FindBy(id="login-button") WebElement loginbtn;
	
	
	
	public void login() {
		
		un.sendKeys("standard_user");
		ps.sendKeys("secret_sauce");
		loginbtn.click();
	}
	
	
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(5);
		driver.close();
		
	     }

}
