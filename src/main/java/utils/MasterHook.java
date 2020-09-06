package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MasterHook extends DriverFactory{
	
	@Before
	public void setup()
	{
		driver = getDriver();
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		try
		{
		if(!(getDriver()==null) && scenario.isFailed())
		{
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
			driver.manage().deleteAllCookies();
			driver.quit();
			driver=null;
		}
		
		if(!(getDriver()==null))
		{
			//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
			driver.manage().deleteAllCookies();
			driver.quit();
			driver=null;
		}
	}catch(Exception e)
		{
		System.out.println("Exception "+e.getMessage());
		}
	}

}
