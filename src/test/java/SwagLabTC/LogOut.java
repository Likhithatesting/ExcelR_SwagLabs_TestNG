package SwagLabTC;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	
	WebDriver driver;

	public LogOut(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}

	public void url() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@FindBy(id = "user-name") WebElement un;
	@FindBy(id = "password") WebElement ps;
	@FindBy(id = "login-button") WebElement loginbtn;
	@FindBy(id = "react-burger-menu-btn") WebElement sidebar;
	@FindBy(id="logout_sidebar_link") WebElement logout;
	
	
	
	public void login() {

		un.sendKeys("standard_user");
		ps.sendKeys("secret_sauce");
		loginbtn.click();
		
	}
	
	public void logout() {
		
		sidebar.click();
		logout.click();
		
	}

}
