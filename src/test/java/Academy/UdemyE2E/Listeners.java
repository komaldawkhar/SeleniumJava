package Academy.UdemyE2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener
{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal <ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onFinish(ITestContext arg0) 
	{
		
		extent.flush();
	}

	public void onStart(ITestContext arg0) 
	{
			
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{
			
	}

	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		String testMethodName =result.getMethod().getMethodName();
		
		try
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		    
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) 
	{
	
	}

	public void onTestSuccess(ITestResult arg0) 
	{
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

}
