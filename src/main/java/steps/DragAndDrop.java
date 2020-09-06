package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class DragAndDrop extends DriverFactory {
	
	Actions act = new Actions(getDriver());
	Action acting = act.build();
	
	@Given("^I login to WebDriver University drag and drop portal$")
	public void i_login_to_WebDriver_University_drag_and_drop_portal() throws Throwable {
	    getDriver().get("http://www.webdriveruniversity.com/Actions/index.html");
	    Thread.sleep(3000);
	}
	
	
	
	@And("^drag and drop a web element$")
	public void drag_and_drop_a_web_element() throws Throwable {
		String beforeDrop = getDriver().findElement(By.xpath("//div[@id='droppable']//p")).getText();
		System.out.println(beforeDrop);
	 Action acting =  act.dragAndDrop(getDriver().findElement(By.xpath("//b[contains(text(),'DRAG ME TO MY TARGET!')]")),
			   getDriver().findElement(By.xpath("//div[@id='droppable']/p/b"))).build();  
	 acting.perform();
	 Thread.sleep(3000);
	 
	 
	 String afterDrop = getDriver().findElement(By.xpath("//div[@id='droppable']/p/b")).getText();
		System.out.println(afterDrop);
	 
	   
	}

	
	@And("^double click on web element$")
	public void double_click_on_web_element() throws Throwable {
	    Action actings = act.doubleClick(getDriver().findElement(By.xpath("//h2[contains(text(),'Double Click Me!')]"))).build();
	    actings.perform();
	}

	
	@And("^perform mouse hover$")
	public void perform_mouse_hover() throws Throwable {
	    Action acting = act.moveToElement(getDriver().findElement(By.xpath("//button[contains(text(),'Hover Over Me First!')]"))).
	    		click(getDriver().findElement(By.xpath("//div[@class='dropdown hover']//a[@class='list-alert'][contains(text(),'Link 1')]"))).build();
	    acting.perform();
	    
	    Alert alert = getDriver().switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	    
	}

	@And("^click and hold on a web element$")
	public void click_and_hold_on_a_web_element() throws Throwable {
	    act.clickAndHold(getDriver().findElement(By.xpath("//div[@id='click-box']")));
	    act.perform();
	    Thread.sleep(3000);    
	}

 
}
