package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{

	public WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	
	By username = By.xpath("//input[@id='user_email']");
	By password = By.id("user_password");
	By signinButton = By.xpath("//input[@name='commit']");
	By forgotPassword = By.cssSelector("a[class='link-below-button']");
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickSignIn()
	{
		return driver.findElement(signinButton);
	}
	
	public ForgotPassword getForgotPassword()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
	
}
