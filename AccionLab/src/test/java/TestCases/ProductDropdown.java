package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ProductDropDown;
import pageObjects.SaucedemoLogin;
import resources.Base;

public class ProductDropdown extends Base{
	public WebDriver driver;
	SaucedemoLogin sl;
	
	 public static Logger log =LogManager.getLogger(Base.class.getName());
@BeforeTest

public void initialize() throws IOException
{
	
	 driver =initializeDriver();
	 log.info("Driver is initialized");
		
	driver.get(prop.getProperty("url"));
	 log.info("Navigated to home page");
}
	
	@Test
	
	public void Addcart() throws IOException, InterruptedException
	{
		sl = new SaucedemoLogin(driver);
		ProductDropDown p = new ProductDropDown (driver);
		sl.getEmail().sendKeys("standard_user");
		sl.getPassword().sendKeys("secret_sauce");
		sl.getLogin().click();
		
		p.getItem(2);
	
		
		log.info("Selected third item from the dropdown");
		
		}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

	
}
