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

public class ValidateTitle extends base
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void Navigation() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		LandingPage lp = new LandingPage(driver);
		
		System.out.println(lp.getTitle().getText());
		Assert.assertEquals(lp.getTitle().getText(), "Featured Courses123");
		log.info("Successfully validated Text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
