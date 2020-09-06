package steps;

//import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import pageObjects.ContactUs_Page;
import utils.DriverFactory;

  

public class ContactUs extends DriverFactory
{
	
	@Given("^I access contact page url$")
	public void i_access_contact_page_url() throws Throwable {
		System.out.println("Entered the step");
		contactuspage.getContactUsPage();  
	}
	
	//@When("^I will click on PAGE OBJECT MODEL$")
	//public void i_click_on_PAGE_OBJECT_MODEL() throws Throwable {
		//getDriver().findElement(By.xpath("//a[@id=\"page-object-model\"]")).click();
	    
	//}

 //@And("^I click on Contact Us$")
	//public void i_click_on_contact_us_section() throws Throwable {
		//String WindowHandle = getDriver().getWindowHandle();
	   // for(String winhandle:getDriver().getWindowHandles())
	   // {
	    	//if(!WindowHandle.equalsIgnoreCase(winhandle))
	    	//{
	    	//	getDriver().switchTo().window(winhandle);
	    	//}
	   // }
		//contactuspage.clickOnSubmit();
	//}
	    

	@And("^I enter first name$")
	public void i_enter_first_name() throws Throwable {
	    contactuspage.enterFirstName();
	}

	@And("^I enter last name$")
	public void i_enter_last_name() throws Throwable {
		contactuspage.enterLastName(); 
	}

	@And("^I enter valid email$")
	public void i_enter_valid_email() throws Throwable {
		contactuspage.enterEmail("rishikesh.gc@gmail.com");
	}

	@And("^I enter comments$")
	public void i_enter_comments() throws Throwable {
		//basepage.WaitUntilWebElementIsVisible(contactuspage.textfield_message);
		contactuspage.enterComments();
	}

	@When("^I click on Submit$")
	public void i_click_on_SUBMIT_button() throws Throwable {
		contactuspage.clickOnSubmit();
	}

	@Then("^Form should be submitted successfully$")
	public void information_should_be_succcessfully_submitted() throws Throwable {
	contactuspage.conntactUsConfirmation();
	}
	
} 