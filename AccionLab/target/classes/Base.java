package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Base {

	public static  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

prop.load(fis);


//String browserName=System.getProperty("browser");  // Uncomment this line if you are sending parameter from Maven
String browserName=prop.getProperty("browser");// comment this line if you are sending parameter from Maven
System.out.println(browserName);

if(browserName.contains("chrome"))
{
	System.out.println("Chrome Browser Environment Created");
	Path currentRelativePath = Paths.get("");
	String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "Driver"
			+ File.separator;
	System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver.exe");
	 ChromeOptions options =new ChromeOptions();
	 if(browserName.contains("headless"))
	 {
	  options.addArguments("headless");
	 }
driver= new ChromeDriver(options);
	
	
}
else if (browserName.equals("firefox"))
{
	 //Firefox code
}
else if (browserName.equals("IE"))
{
//IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;

}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}
