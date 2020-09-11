package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

//Creating an constructor
	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	By signin = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//*[contains(text(),'Featured Courses')]");
	By navBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");

	public WebElement getLogin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

    //to get the list of navigable items
	public int getNavItemsCount() {
    List<WebElement> navItemsList  = driver.findElements(By.cssSelector("ul.nav.navbar-nav.navbar-right li"));
    return navItemsList.size();  
	}
}
