package SwagLabTC;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}

	public void url() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@FindBy(id = "user-name")
	WebElement un;
	@FindBy(id = "password")
	WebElement ps;
	@FindBy(id = "login-button")
	WebElement loginbtn;
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addCartbutton;
	@FindBy(id = "remove-sauce-labs-backpack")
	WebElement removeCartbutton;
	@FindBy(className = "shopping_cart_badge")
	WebElement cartBadge;
	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;

	public void login() {

		un.sendKeys("standard_user");
		ps.sendKeys("secret_sauce");
		loginbtn.click();
	}

	public void addToCart() {

		addCartbutton.click();
	}

	public void getCartBadgeCount() {

		System.out.println(cartBadge.getText());
	}

	public void goToCart() {

		cartIcon.click();
	}

	public void removeFromCart() {

		removeCartbutton.click();
	}

	public void closeBrowser() throws InterruptedException {

		Thread.sleep(5);
		driver.close();

	}

}
