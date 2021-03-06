package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{

	public WebDriver driver;
	
	
	public LandingPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	
	By signin = By.cssSelector("a[class='theme-btn register-btn']");
	By title = By.cssSelector("div[class='pull-left'] h2");
	By navigation = By.xpath("//ul[@class='navigation clearfix']/li/a");
	
	
	
	
	public LoginPage getSignIn()
	{
		driver.findElement(signin).click();
		LoginPage lp =new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigation);
	}
	
}
