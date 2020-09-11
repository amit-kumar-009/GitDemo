package Academy;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class HomePageTest extends BaseClass {
	WebDriver driver;
public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest
	public void invokeBrowser() throws Exception {
		driver = startDriver();
		log.info("Driver has been started successfully");
	}

	@Test(dataProvider = "getData")
	public void pageNavigation(String username, String password, String text) throws Exception {
		driver.get(prop.getProperty("url"));
		log.info("Desired url invoked successfully");
		// Creating an object of LandingPage Class
		LandingPage landingObject = new LandingPage(driver);
		landingObject.getLogin().click();
		log.info("clicked on login");

		LoginPage loginObject = new LoginPage(driver);
		loginObject.getEmail().sendKeys(username);
		loginObject.getPassword().sendKeys(password);
		System.out.println(text);
		loginObject.getLogin().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "amitalok001@gmail.com";
		data[0][1] = "12345";
		data[0][2] = "Non-Restricted User";

		// 2nd set of records
		data[1][0] = "amitalok002@gmail.com";
		data[1][1] = "1234456";
		data[0][2] = "Restricted User";
		return data;

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
