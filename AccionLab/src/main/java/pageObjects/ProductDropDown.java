package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ProductDropDown {

	
	public  WebDriver driver;
	
	

	private By ItemClick=By.cssSelector("#inventory_filter_container > select");

	
	public ProductDropDown(WebDriver driver) {
	
		
		this.driver=driver;
		
	}
	public SaucedemoLogin getLogin()
	{
	
		 SaucedemoLogin sl=new SaucedemoLogin(driver);
		 return sl;
		 
		 
		 
	}
	public WebElement dropdown() {
		return driver.findElement(ItemClick);
	}

	public void getItem(int index)
	{
		WebElement ele = driver.findElement(ItemClick);
		Select drop = new Select(ele);
		drop.selectByIndex(index); 
	}

}
