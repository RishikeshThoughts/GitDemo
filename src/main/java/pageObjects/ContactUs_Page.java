package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactUs_Page extends BasePage{
	
	public ContactUs_Page() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public @FindBy(xpath="//input[@name='first_name']") WebElement textfield_firstname;
	public @FindBy(xpath="//input[@name='last_name']") WebElement textfield_lastname;
	public @FindBy(xpath="//input[@name='email']") WebElement textfield_email;
	public @FindBy(xpath="//textarea[@name='message']") WebElement textfield_comments;
	public @FindBy(xpath="//input[@value='SUBMIT']") WebElement button_submit;
	public @FindBy(xpath="//input[@type='reset']") WebElement textfield_reset;
	public @FindBy(xpath="//h1[contains(text(),'Thank You for your Message!')]") WebElement textfield_message;
	

	//public ContactUs_Page() throws IOException {
		//super();
	//}	
	
		public ContactUs_Page getContactUsPage() throws Exception 
		{	
			getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
			return new ContactUs_Page();
		}
		
		public ContactUs_Page enterFirstName() throws Exception
		{
			sendKeysToWebElement(textfield_firstname, "Rishi");
			return new ContactUs_Page();
		}
		
		public ContactUs_Page enterLastName() throws Exception
		{
			sendKeysToWebElement(textfield_lastname, "Kesh");
			return new ContactUs_Page();
		}
		
		public ContactUs_Page enterEmail(String email) throws Exception
		{
			sendKeysToWebElement(textfield_email, email);
			return new ContactUs_Page();
		}
		
		public ContactUs_Page enterComments() throws Exception
		{
			sendKeysToWebElement(textfield_comments, "Comments entered by Rishi");
			return new ContactUs_Page();
		}
		
		public ContactUs_Page clickOnSubmit() throws Exception
		{
			waitAndClickElement(button_submit);
			return new ContactUs_Page();
		}
		
		public ContactUs_Page conntactUsConfirmation() throws Exception
		{
			
			WaitUntilWebElementIsVisible(textfield_message);
			String message = getDriver().findElement(By.xpath("//h1[contains(text(),'Thank You for your Message!')]")).getText();
			Assert.assertEquals(message, "Thank You for your Message!123");
			return new ContactUs_Page();
		}
	
}


