package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword 
{

	public WebDriver driver;
	
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver =driver;
	}
	
	
	By email = By.cssSelector("#user_email");
	By sendMeInstructions= By.cssSelector("input[name='commit']");
	
	
	/*public LoginPage getLogIn()
	{
		driver.findElement(LogIn).click();
		LoginPage lp =new LoginPage(driver);
		return lp;
	}*/
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getSetmeInstructions()
	{
		return driver.findElement(sendMeInstructions);
	}
	
}
