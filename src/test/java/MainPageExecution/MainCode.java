package MainPageExecution;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import SwagLabTC.AddCartQty;
import SwagLabTC.CartPage;
import SwagLabTC.IncorrectLogin;
import SwagLabTC.LogOut;
import SwagLabTC.LoginPage;
import SwagLabTC.PlaceOrder;
import SwagLabTC.ProductPage;
import SwagLabTC.ProductSorting;

public class MainCode {
	
WebDriver driver;
	
	LoginPage lp;
	CartPage cp;
	PlaceOrder po;
	LogOut lo;
	IncorrectLogin il;
	AddCartQty acq;
	ProductPage pp;
	ProductSorting ps;
	
	
	@BeforeSuite
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		lp = new LoginPage(driver);
		cp = new CartPage(driver);
		po = new PlaceOrder(driver);
		lo = new LogOut(driver);
		il = new IncorrectLogin(driver);
		acq = new AddCartQty(driver);
		pp = new ProductPage(driver);
		ps = new ProductSorting(driver);
		
	}
	
	
	@Test(priority = 1)
	public void Login() throws InterruptedException {

	lp.url();
	lp.login();
	lp.closeBrowser();
	
	}
	
	@Test(priority = 2)
	public void Cart() throws InterruptedException {

	cp.url();
	cp.login();
	cp.addToCart();
	cp.getCartBadgeCount();
	cp.goToCart();
	cp.removeFromCart();
	cp.closeBrowser();
	
	}
	
	@Test(priority = 3)
	public void placeOrder() throws InterruptedException, IOException {

	po.url();
	po.login();
	po.addToCart();
	po.goToCart();
	po.checkOut();
	po.InfoDetails();
	po.displayCartDetails();
	
	}
	
	@Test(priority = 4)
	public void IncorrectLogin() {

	lo.url();
	lo.login();
	lo.logout();
	
	}
	
	@Test(priority = 5)
	public void LogOut() {

	il.url();
	il.login();
	
	}
	
	@Test(priority = 6)
	public void AddCartQty() {

	acq.url();
	acq.login();
	acq.addToCart();
	acq.getCartBadgeCount();
	acq.goToCart();
	acq.addQty();
	
	}
	
	@Test(priority = 7)
	public void ProductPage() {
		
		pp.url();
		pp.login();
		pp.SortFunctionality();
		pp.getFirstProductTitle();
		pp.ProductList();
	
	
	}
	
	@Test(priority = 8)
	public void ProductSorting() {
		
		ps.url();
		ps.login_detail();
		ps.SortFunctionality();
		ps.addTocart();
		ps.verifyCart();
		ps.checkOut();
		ps.orderConfirmation();
	
	}

}
