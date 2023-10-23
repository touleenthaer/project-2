import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTestCase {
	
	WebDriver driver =new ChromeDriver()  ; 
//	WebDriver driver2 =new FirefoxDriver()  ; 
//	WebDriver driver3 =new EdgeDriver()  ; 
	@BeforeTest
	public void mySetup() {
		driver.get("https://www.saucedemo.com/");
//		driver2.get("https://www.saucedemo.com/");
//		driver3.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		driver.manage().window().maximize();

	    List<WebElement> addtoCartButtons = driver.findElements(By.className("btn_primary"));
		List<WebElement> itemsName =driver.findElements(By.className("inventory_item_name" ));
		List<WebElement> itemsPrice =driver.findElements(By.className("inventory_item_price" ));
		for(int i = 0 ;i<addtoCartButtons.size();i++) {
			addtoCartButtons.get(i).click();
			System.out.println(itemsName.get(i).getText() + " Has Been Added and the price is "+itemsPrice.get(i).getText());
			
			}
		
		
	}
	
	
	@Test()
	public void MyFirstTest ( ) {}
	
	@AfterTest
	public void MyPostTesting() {}

}
