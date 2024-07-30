package SwagLabTC;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartQty {
	
	WebDriver driver;

	public AddCartQty(WebDriver idriver) {
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
	@FindBy(id = "add-to-cart-sauce-labs-backpack") WebElement product1;
	@FindBy(id = "add-to-cart-sauce-labs-bike-light") WebElement product2;
	@FindBy(className = "shopping_cart_badge") WebElement cartBadge;
	@FindBy(className = "shopping_cart_link") WebElement cartIcon;
	@FindBy(id="continue-shopping") WebElement cont;
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt") WebElement product3;
	@FindBy(id="cart_contents_container") WebElement cartInfo;

	public void login() {

		un.sendKeys("standard_user");
		ps.sendKeys("secret_sauce");
		loginbtn.click();
	}

	public void addToCart() {

		product1.click();
		product2.click();
	}

	public void getCartBadgeCount() {

		System.out.println("==========================================");
		System.out.println(cartBadge.getText());
		System.out.println("==========================================");
	}

	public void goToCart() {

		cartIcon.click();
	}
	
	public void addQty() {
		
		cont.click();
		product3.click();
		cartIcon.click();
		System.out.println("==========================================");
		System.out.println(cartBadge.getText());
		System.out.println("==========================================");
		System.out.println(cartInfo.getText());
		System.out.println("==========================================");
		
	}


}
