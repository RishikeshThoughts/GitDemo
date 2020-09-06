package steps;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class ButtonClick extends DriverFactory{
	
	
	@Given("^I login to WebDriver University portal$")
	public void i_login_to_WebDriver_University_portal() throws Throwable {
		getDriver().get("https://www.webdriveruniversity.com");
		Thread.sleep(3000);

	}

	@And("^I click on Button Clicks option$")
	public void i_click_on_Button_Clicks_option() throws Throwable {
	    getDriver().findElement(By.xpath("//h1[contains(text(),'BUTTON CLICKS')]")).click();
	    Thread.sleep(5000);
	}

	@And("^I click on Web Element click$")
	public void i_click_on_Web_Element_click() throws Throwable {
		
		String sets = getDriver().getWindowHandle();
		Set<String> set = getDriver().getWindowHandles();
		for(String sett : set) 
		{
			if(!sett.equalsIgnoreCase(sets))
			{
				getDriver().switchTo().window(sett);
			}
		}
		getDriver().findElement(By.xpath("//p[contains(text(),'CLICK ME!')]")).click();	
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//div[@id='myModalClick']//button[@class='btn btn-default'][contains(text(),'Close')]")).click();
	}
	
	@And("^I click on Java Script click$")
	public void i_click_on_Java_Script_click() throws Throwable {
		
		//String sets = getDriver().getWindowHandle();
		//Set<String> set = getDriver().getWindowHandles();
		//for(String sett : set) 
		//{
			//if(!sett.equalsIgnoreCase(sets))
			//{
			//	getDriver().switchTo().window(sett);
			//}
		//}
		
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//span[@id='button2']")));
		Thread.sleep(3000);
			getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-md']//button[@class='btn btn-default'][contains(text(),'Close')]")).click();
		js.executeScript("document.getElementById('button2']').click();");		
				
	}
	
	@And("^I click on Actions click$")
	public void i_click_on_Actions_click() throws Throwable {
		
		WebElement element = getDriver().findElement(By.xpath("//span[@id='button3']"));
		Actions act = new Actions(getDriver());
		act.moveToElement(element).click(element);
		Action action=act.build();
		action.perform();
		Thread.sleep(5000);
		act.moveToElement(getDriver().findElement(By.xpath("//div[@id='myModalMoveClick']//h4[1]"))).doubleClick();
		act.build().perform();;
		Thread.sleep(3000);
				
	}

}
 