package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass 
{
    public WebDriver driver;
    public Properties prop;
    
	public WebDriver startDriver() throws Exception {
		
		
		//Creating an object of the Properties class
		prop = new Properties();
		
		//Creating an inputStream object to connect with data.properties file
		FileInputStream fis = 
				new FileInputStream("C:\\Users\\amit\\eclipse_workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		//configuring property object and file object
		prop.load(fis);
		
		//extracting browser's name
		String browserName = prop.getProperty("browser");
		
		//checking for different set of browsers
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Eclipse\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			//Defining desired capabilities to our browser to handle insecure sites
			DesiredCapabilities dc  = DesiredCapabilities.chrome();
			dc.acceptInsecureCerts();
			//Now, creating general chrome profile
			ChromeOptions co  = new ChromeOptions();
			co.merge(dc);			
			driver = new ChromeDriver(co);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//Page_Synchronization
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//Finally, returning driver object
		return driver;
	}
}
