package SwagLabTC;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;

	public ProductPage(WebDriver idriver) {
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
    @FindBy(className="inventory_item") WebElement productItem;
    @FindBy(xpath="//select[@class='product_sort_container']") WebElement sort;
	@FindBy(xpath="//select[@class='product_sort_container']/option[3]") WebElement option3;
	@FindBy(xpath="//div[@class='inventory_list']/div[1]/div/div/a/div") WebElement firstProduct;
	@FindBy(xpath="//div[@class='inventory_details']/div/div/div[1]") WebElement firstProductTitle;
    @FindBy(id="back-to-products") WebElement back;
    
    public void login() {

		un.sendKeys("standard_user");
		ps.sendKeys("secret_sauce");
		loginbtn.click();
	}


    public void SortFunctionality()
	{
		sort.click();
		option3.click();
	}

    public void getFirstProductTitle() {
    	firstProduct.click();
        System.out.println(firstProductTitle.getText());
        System.out.println("=====================================");
        back.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    
    public void ProductList() {
    	
    	List<WebElement> product = driver.findElements(By.xpath("//div[@class='inventory_list']/div/div/div/a"));
		
		for(int i =0;i<product.size();i++) {
			System.out.println(product.get(i).getText());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			System.out.println("=====================================");
        
		}
    }

}
