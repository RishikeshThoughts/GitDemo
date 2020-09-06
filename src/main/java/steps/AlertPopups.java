package steps;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class AlertPopups extends DriverFactory {
	
	
	
	@Given("^I login to WebDriver University Alerts portal$")
	public void i_login_to_WebDriver_University_Alerts_portal() throws Throwable {
	    getDriver().get("http://www.webdriveruniversity.com");
	    getDriver().findElement(By.xpath("//h1[contains(text(),'POPUP & ALERTS')]")).click();
	    Set<String> set = getDriver().getWindowHandles();
	    for(String s : set)
	    {
	    	if(!s.equalsIgnoreCase(getDriver().getWindowHandle()))
	    	{
	    		driver.switchTo().window(s);
	    	}
	    	
	    }
	    getDriver().findElement(By.xpath("//span[@id='button1']//p[contains(text(),'CLICK ME!')]")).click();
	    Thread.sleep(3000);
	    Alert alert = getDriver().switchTo().alert();
	    alert.accept();
	    
	    getDriver().findElement(By.xpath("//a[contains(text(),'CLICK ME!')]")).click();
	    WebDriverWait wait = new WebDriverWait(getDriver(), 15);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'CLICK ME!')]")));
	    element.click();
	  
	}

	/*
	@And("^I work on normal alert$")
	public void i_work_on_normal_alert() throws Throwable {
		Alert alert = getDriver().switchTo().alert();
	    getDriver().findElement(By.xpath("//span[@id='button1']")).click();
	    Thread.sleep(3000);
	    alert.accept();
	    getDriver().findElement(By.xpath("//span[@id='button2']//p[contains(text(),'CLICK ME!')]")).click();
	    Thread.sleep(3000);
	    alert.dismiss();
	    
	}
	*/

}
