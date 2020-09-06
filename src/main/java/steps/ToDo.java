package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class ToDo extends DriverFactory{
	
	Actions act = new Actions(getDriver());
	
	@Given("^I login to WebDriver University Actions portal$")
	public void i_login_to_WebDriver_University_Actions_portal() throws Throwable {
	    getDriver().get("http://www.webdriveruniversity.com/To-Do-List/index.html");
	}

	@And("^I click on to add new Todo$")
	public void i_click_on_to_add_new_Todo() throws Throwable {
	    getDriver().findElement(By.xpath("//input[@placeholder='Add new todo']")).click();
	    
	}

	
	@And("^I save the ToDo$")
	public void i_save_the_ToDo() throws Throwable {
		getDriver().findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys("Hellos");
		getDriver().findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
	}

	@And("^I highlight the added ToDo$")
	public void i_highlight_the_added_ToDo() throws Throwable {
		
		Action acting = act.doubleClick(getDriver().findElement(By.xpath("//li[contains(text(),'Hellos')]"))).build();
		 acting.perform();
		 Thread.sleep(3000);
	}

	@And("^I delete the added ToDo$")
	public void i_delete_the_added_ToDo() throws Throwable {
		getDriver().findElement(By.xpath("//li[contains(text(),'Hellos')]//i[@class='fa fa-trash']")).click();
		Thread.sleep(3000);
	}

	@And("^I click on plus symbol$")
	public void i_click_on_plus_symbol() throws Throwable {
	    getDriver().findElement(By.xpath("//i[@id='plus-icon']")).click();
	    Thread.sleep(3000);
	}
	

}
