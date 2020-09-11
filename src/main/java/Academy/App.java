package Academy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.*;

public class App {
public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Eclipse\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https:\\www.facebook.com");	
		Thread.sleep(5000);
		takeScreenshot("FB_Login_Page");
		driver.close();
	}
	public static void takeScreenshot(String fileName) throws IOException {
		TakesScreenshot srcShot = (TakesScreenshot)driver;
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+fileName+".jpg";
		//FileUtils.copyFile(srcFile, new File(destinationFile));
		FileUtils.copyFile(srcFile, new File(destinationFile));
	}
}
