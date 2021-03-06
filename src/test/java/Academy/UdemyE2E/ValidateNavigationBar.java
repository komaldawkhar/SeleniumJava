package Academy.UdemyE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void Navigation() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		
		LandingPage lp = new LandingPage(driver);
		//System.out.println(lp.getNavigationBar().isDisplayed());
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation bar successfully Displayed");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
