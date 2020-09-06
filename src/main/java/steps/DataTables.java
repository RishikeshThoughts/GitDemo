package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class DataTables extends DriverFactory{

	@Given("^I login to WebDriver University data tables$")
	public void i_login_to_WebDriver_University_data_tables() throws Throwable {
		
		getDriver().get("http://www.webdriveruniversity.com/Data-Table/index.html");
	    
	}

	@Given("^to fetch the first row data$")
	public void to_fetch_the_first_row_data() throws Throwable {
		
		List<WebElement> li = getDriver().findElements(By.xpath("//table[@id='t01']//th[contains(text(),'Firstname')]"));
		System.out.println(li.get(0).toString());
	    
	}


}
