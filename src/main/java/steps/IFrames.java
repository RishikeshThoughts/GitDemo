package steps;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class IFrames extends DriverFactory{

	
	@Given("^I login to WebDriver University frames portal$")
	public void i_login_to_WebDriver_University_frames_portal() throws Throwable {
		getDriver().get("http://www.webdriveruniversity.com/Hidden-Elements/index.html");
		Thread.sleep(3000);
	    
	}

	@And("^I get value of first element$")
	public void i_get_value_of_first_element() throws Throwable {
		System.out.println(getDriver().findElement(By.xpath("//h2[contains(text(),'Not Displayed')]")).getText());
	}

}
