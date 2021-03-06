package Academy.UdemyE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base
{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void Navigation() throws IOException
	{
		driver = initializeDriver();
		
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		
		//creating object to that class and invoke methods of it
		
		LandingPage lp = new LandingPage(driver);
		
		//lp.getSignIn();
		
		LoginPage lp1=lp.getSignIn();
		
		//LoginPage lp1 = new LoginPage(driver);
		//log.getUsername().sendKeys("abc@gmail.com");
		
		lp1.getUsername().sendKeys(username);
		lp1.getPassword().sendKeys(password);
		
		//log.getPassword().sendKeys("Komal89");
		
		//lp1.clickSignIn().click();
		log.info("Login details Entered");
		
		/*lp1.clickSignIn().click();
		ForgotPassword fp = lp1.getForgotPassword();
		fp.getEmail().sendKeys("cdcx");
		fp.getSetmeInstructions().click();*/
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456789";
		
		return data;
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
