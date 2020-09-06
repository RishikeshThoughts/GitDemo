package steps;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import utils.DriverFactory;

public class Accordion extends DriverFactory{
	
	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	
	@Given("^I login to WebDriver University Accordion portal$")
	public void i_login_to_WebDriver_University_Accordion_portal() throws Throwable {
	    getDriver().get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
	}

	@And("^I click Manual menu$")
	public void i_click_Manual_menu() throws Throwable {
		//getDriver().findElement(By.xpath("//button[@id='click-accordion']")).click();
		//Thread.sleep(3000);
		//System.out.println(getDriver().findElement(By.xpath("//button[@id='click-accordion']")).getText());
		//WebElement	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='timeout']")));
	   // System.out.println(element.getText());
	   // System.out.println(element.getTagName());
	   // Thread.sleep(3000);
	   // Assert.assertEquals("This text has appeared after 5 seconds!",getDriver().findElement(By.xpath("//div[@id='timeout']")).getText());
		
		WebElement element = getDriver().findElement(By.xpath("//select[@id='dropdowm-menu-1']"));
		Select select = new Select(element);
		
		select.selectByVisibleText("Python");
		List<WebElement> webelement = select.getOptions();
		for(WebElement ele : webelement)
		{
			if(ele.isEnabled())
			{
			System.out.println("Drop down options "+ele.getText());
			}
		}
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		
		List<WebElement> list = getDriver().findElements(By.xpath("//div[@id='checkboxes']"));
		getDriver().findElement(By.xpath("//label[contains(text(),'Option 1')]")).click();
		for(WebElement ele : list)
		{
			if(ele.isSelected())
			{
				ele.click();
				Thread.sleep(3000);
			}
		}
		
		WebElement element1 = getDriver().findElement(By.xpath("//form[@id='radio-buttons']/input[@value=\"orange\"]"));
		element1.click();
		System.out.println(element1.isSelected());
		
		List<WebElement> elements = getDriver().findElements(By.xpath("//form[@id='radio-buttons']"));
		
		for(WebElement ele : elements)
		{
			if(!ele.isSelected())
			{
				System.out.println("Radio buttons are "+ele.getText());
			}
		}
		
		List<WebElement> listing = getDriver().findElements(By.xpath("//form[@id='radio-buttons-selected-disabled']"));
		Thread.sleep(3000);
		
		for(int i=0;i<listing.size();i++)
		{
			//if(!ele1.isEnabled())
			//{
				System.out.println("Status "+listing.get(i).isEnabled());
				//System.out.println("Status " +ele1.isEnabled());
			//}
			//if(ele1.isSelected())
			//{
			//	System.out.println("Checked options is "+ ele1.getText());
			//}
		}
		
		Select sel = new Select(getDriver().findElement(By.xpath("//select[@id='fruit-selects']")));
		List<WebElement> lisel = sel.getOptions();
		for(WebElement ele2 : lisel)
		{
			if(!ele2.isEnabled())
			{
				System.out.println("Disabled option is "+ele2.getText());
			}
		}


		
	}


}
