package SwagLabTC;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrder {
	
	WebDriver driver;

	public PlaceOrder(WebDriver idriver) {
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
	@FindBy(id="checkout") WebElement checkOutBtn;
	
	@FindBy(xpath="//div[@class='checkout_summary_container']") WebElement summary;
	@FindBy(id="finish") WebElement finish;
	@FindBy(xpath="//div[@class='checkout_complete_container']") WebElement ordersummary;
	@FindBy(id="back-to-products") WebElement backhome;	
	

	public void login() {

		un.sendKeys("standard_user");
		ps.sendKeys("secret_sauce");
		loginbtn.click();
	}

	public void addToCart() {

		addCartbutton.click();
	}

	public void goToCart() {

		cartIcon.click();
	}

	public void checkOut() {

		checkOutBtn.click();
	}
	
	public void InfoDetails() throws IOException {
		String filepath = "D:\\ExcelR\\SELENIUM\\Jyothi Shukla Trainer\\PROJECTS\\SwagLabs_Project_3\\Input Data.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Data");
			
		int rows = sheet.getLastRowNum();
			
		for(int r=1;r<=rows;r++) {
			XSSFRow row = sheet.getRow(r);
			XSSFCell fname = row.getCell(0);
			XSSFCell lname = row.getCell(1);
			XSSFCell zip = row.getCell(2);
			
				
				try {
				driver.findElement(By.id("first-name")).sendKeys(fname.toString());
				driver.findElement(By.id("last-name")).sendKeys(lname.toString());
				driver.findElement(By.id("postal-code")).sendKeys(zip.toString());
				driver.findElement(By.id("continue")).click();
				
				System.out.println("Valid Data");
				}
				catch(Exception e) {
					System.out.println("Invalid Data");
				}
			}
			fis.close();

			}
	
	public void displayCartDetails() {
		
		System.out.println("===============================================");
		System.out.println(summary.getText());
		finish.click();
		System.out.println("===============================================");
		System.out.println(ordersummary.getText());
		System.out.println("===============================================");
		backhome.click();
	}

	public void closeBrowser() throws InterruptedException {

		Thread.sleep(5);
		driver.close();

	}

}
