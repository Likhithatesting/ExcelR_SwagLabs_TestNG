package SwagLabTC;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncorrectLogin {
	
	WebDriver driver;

	public IncorrectLogin(WebDriver idriver) {
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
	@FindBy(xpath = "//div[@class='error-message-container error']") WebElement errormsg;
	
	
	public void login() {

		un.sendKeys("standard");
		ps.sendKeys("secret_sauce");
		loginbtn.click();
		System.out.println(errormsg.getText());
		
	}

}
