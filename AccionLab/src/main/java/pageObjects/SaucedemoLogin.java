package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SaucedemoLogin {

	public WebDriver driver;
	
	private By email=By.cssSelector("[id='user-name']");
	private By password=By.cssSelector("[id='password']");
	private By login=By.cssSelector("[id='login-button']");

	
	public SaucedemoLogin(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	
}
