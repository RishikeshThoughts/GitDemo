package utils;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import pageObjects.BasePage;
import pageObjects.ContactUs_Page;
import pageObjects.Products_Page;

public class DriverFactory {
	public static WebDriver driver;
    public static ContactUs_Page contactuspage;
    public static Products_Page productspage;
    public static BasePage basepage;

	public WebDriver getDriver() {
		
	try {
		
		//ReadConfigFile file = new ReadConfigFile();
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\config.properties");
		p.load(fi);
		String browsername = p.getProperty("browser");
		
	switch(browsername)
	{
	 
	case "firefox" :
		if(null==driver)
		{
			System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			//FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.addPreference("Marinate",true);
	        driver=new FirefoxDriver();
	        driver.manage().window().maximize();
		}
		break;
		
	case "chrome" :
		if(null==driver)
		{
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
	        driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        //driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		}
		break;
	
	case "IE" :
		if(null==driver)
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
			capabilities.setCapability("ignorezoomsetting", true);
			driver=new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			
		}
		break;
	}
	}catch(Exception e)
	{
		System.out.println("Unable to load browser "+e.getMessage());
	}finally
	{
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		contactuspage = PageFactory.initElements(driver, ContactUs_Page.class);
		productspage = PageFactory.initElements(driver, Products_Page.class);
		//basepage = PageFactory.initElements(driver, BasePage.class);
	}
	return driver;
}
	
}

	
