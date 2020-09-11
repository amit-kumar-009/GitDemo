package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class ValidateTitleTest extends BaseClass{
	WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void invokeBrowser() throws Exception {
		driver = startDriver();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
		
    @Test
	public void pageNavigation() throws Exception {
		driver.get(prop.getProperty("url"));

		//Creating an object of LandingPage Class
		LandingPage landingObject = new LandingPage(driver);
	    Assert.assertEquals(landingObject.getTitle().getText(), "Featured Courses");
}
}