package steps;

import java.io.IOException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ViewProduct extends DriverFactory {
	
	@Given("^I access webdriveruniversity WebDriverUniversity url$")
	public void i_access_webdriveruniversity_WebDriverUniversity_url() throws IOException {
		productspage.getProductsPage();
	    
	}

	//@When("^I click on PAGE OBJECT MODEL$")
	//public void i_click_on_PAGE_OBJECT_MODEL() throws Throwable {
		//getDriver().findElement(By.xpath("//a/div/div/h1[contains(text(),'PAGE OBJECT MODEL')]")).click();
	    
	//}

	//@When("^I click on Our Prducts link$")
	//public void i_click_on_Our_Prducts_link() throws Throwable {
		//for(String s:getDriver().getWindowHandles())
		///{
			//getDriver().switchTo().window(s);
		//}
		//getDriver().findElement(By.xpath("//a[contains(text(),'Our Products')]")).click();
	    
	//}
	
	
	@When("^I click to view special offers$")
	public void i_click_to_view_special_offers() throws Throwable {
		productspage.clickOnSpecialOffer();
	}
	
	@And("^I read the voucher code$")
	public void i_read_the_voucher_code() throws Throwable
	{
		System.out.println(productspage.voucherCode());
	}

	@Then("^I cick on proceed to move further$")
	public void i_cick_on_proceed_to_move_further() throws Throwable {
	    productspage.clickOnProceed();
	   
	}
	
}
