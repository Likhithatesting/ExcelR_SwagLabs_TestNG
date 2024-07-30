package SwagLabTC;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductSorting {
	
	WebDriver driver;


	public ProductSorting(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//input[@id='user-name']") WebElement  username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//input[@id='login-button']") WebElement login;
	@FindBy(xpath="//select[@class='product_sort_container']") WebElement sort;
	@FindBy(xpath="//select[@class='product_sort_container']/option[2]") WebElement option2;
	@FindBy(xpath="//div[@id='inventory_container']/div/div/div/div/div/a") WebElement selectItemImg;
	@FindBy(xpath="//div[@class='inventory_details']/div/div[2]/button") WebElement addTocartBtn;
	@FindBy(xpath="//div[@id='root']/div/div/div/div/div[3]/a") WebElement VerifyCart;
	@FindBy(xpath="//div[@id='root']/div/div/div[2]/div/div[2]/button[2]") WebElement checkOut;
	@FindBy(xpath="//div[@id='root']/div/div/div[2]/div/form/div/div/input") WebElement firstName;
	@FindBy(xpath="//div[@id='root']/div/div/div[2]/div/form/div/div[2]/input") WebElement lastName;
	@FindBy(xpath="//div[@id='root']/div/div/div[2]/div/form/div/div[3]/input") WebElement zipCode;
	@FindBy(xpath="//div[@id='root']/div/div/div[2]/div/form/div[2]/input") WebElement countinue;
	@FindBy(xpath="//div[@id='root']/div/div/div[2]/div/div[2]/div[9]/button[2]") WebElement finish;
	@FindBy(xpath="//div[@id='root']/div/div/div[2]/h2") WebElement confirmationMsg;
	@FindBy(xpath="//div[@id='root']/div/div/div[2]/button") WebElement backTohome;
	
	public void url() {
		driver.get("https://www.saucedemo.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://www.saucedemo.com/");
		System.out.println("Page is Visible");
	}
	
	public void login_detail()
	{
		
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		login.click();
	}
	
	public void SortFunctionality()
	{
		sort.click();
		option2.click();
	}
	
	public void addTocart()
	{
	
		selectItemImg.click();
		addTocartBtn.click();
	}
	
	public void verifyCart()
	{
	
		VerifyCart.click();
		checkOut.click();
	}
	
	public void checkOut()
	{
		firstName.sendKeys("pratiksha");
		lastName.sendKeys("chougale");
		zipCode.sendKeys("64646");
		countinue.click();
		finish.click();
	}
	
	public void orderConfirmation()
	{
		String s1=confirmationMsg.getText();
		String s2="Thank you for your order!";
		
		Assert.assertEquals(s2, s1);
		System.out.println("order successfully placed");
		backTohome.click();
	
	}

}
