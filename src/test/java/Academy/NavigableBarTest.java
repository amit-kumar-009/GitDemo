package Academy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.BaseClass;

public class NavigableBarTest extends BaseClass{
	WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void invokeBrowser() throws Exception {
		driver = startDriver();
		driver.get(prop.getProperty("url"));
		//driver.get("https://www.amazon.in");
	}	
	@Test
	public void pageNavigation() throws Exception {	
		LandingPage landingObject = new LandingPage(driver);
		Assert.assertTrue(landingObject.getNavBar().isDisplayed());
		Assert.assertEquals(landingObject.getNavItemsCount(), 8);
	System.out.println("I am passed");
	Thread.sleep(10000);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
}
