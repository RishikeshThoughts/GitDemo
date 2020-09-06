package steps;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class Scroll_Down extends DriverFactory 
{
	
	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	
	@Given("^I login to WebDriver University Scrolling portal$")
	public void i_login_to_WebDriver_University_Scrolling_portal() throws Throwable
	{
	    getDriver().get("http://www.webdriveruniversity.com/Scrolling/index.html");
	    Thread.sleep(3000);
	}

	@And("^I scroll down to bottom of the page$")
	public void i_scroll_down_to_bottom_of_the_page() throws Throwable 
	{
	    
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(3000);
	    
	}

	@And("^I read the text box$")
	public void i_read_the_text_box() throws Throwable
	{
		System.out.println(getDriver().findElement(By.xpath("//div[@id='zone4']")).getText());
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		TakesScreenshot tks  = ((TakesScreenshot)getDriver());
		File srcFile = tks.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\Users\\Rishikesh\\Desktop\\Selenium BDD Automation\\Selenium_with_Cucumber\\CucumberTest\\target\\image.png");
		FileUtils.copyFile(srcFile, destFile);
		Thread.sleep(3000);
	}

}

