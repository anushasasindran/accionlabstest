package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.SaucedemoLogin;

import resources.Base;

public class LoginPage extends Base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	 
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 log.info("Initialized the driver");
	}
	
	@Test(dataProvider="getData")
	
	public void userLogin(String Username,String Password, String text) throws IOException
	{

		driver.get(prop.getProperty("url"));
		SaucedemoLogin sl=new SaucedemoLogin(driver);
		sl.getEmail().sendKeys(Username);
		sl.getPassword().sendKeys(Password);

		log.info(text);
		
		sl.getLogin().click();
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
	}

	@DataProvider
	public Object[][] getData()
	{

		Object[][] data=new Object[1][3];
	
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		data[0][2]="testdata set 1";
	
		
		return data;
		
		
	}
	
}
