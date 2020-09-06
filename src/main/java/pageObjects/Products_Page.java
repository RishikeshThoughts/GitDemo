package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends BasePage{
	
	public @FindBy(xpath="//p[contains(text(),'Special Offers')]") WebElement button_specialoffers;
	public @FindBy(xpath="//p[contains(text(),'Cameras')]") WebElement button_cameras;
	public @FindBy(xpath="//p[contains(text(),'New Laptops')]") WebElement button_newlaptops;
	public @FindBy(xpath="//p[contains(text(),'Game Console')]") WebElement button_game;
	public @FindBy(xpath="//p[contains(text(),'Old Laptops')]") WebElement button_usedlaptops;
	public @FindBy(xpath="//p[contains(text(),'Components')]") WebElement button_components;
	public @FindBy(xpath="//p[contains(text(),'Audio')]") WebElement button_audio;
	public @FindBy(xpath="//p[contains(text(),'Desktop Systems')]") WebElement button_desktop;
	public @FindBy(xpath="//button[contains(text(),'Proceed')]") WebElement button_Proceed_popup;
	public @FindBy(xpath="//button[contains(text(),'Close')]") WebElement button_Close_popup;
	public @FindBy(xpath="//b[contains(text(),\"NEWCUSTOMER\")]") WebElement vouchercode;

	public Products_Page() throws IOException {
		super();
	}
		
	public Products_Page getProductsPage() throws IOException
	{
		getDriver().get("http://www.webdriveruniversity.com/Page-Object-Model/products.html#");
		return new Products_Page();
	}
	
	public Products_Page clickOnSpecialOffer() throws InterruptedException, IOException
	{
		waitAndClickElement(button_specialoffers);
		return new Products_Page();
	}
	
	public Products_Page clickOnNewLaptop() throws InterruptedException, IOException
	{
		waitAndClickElement(button_newlaptops);
		return new Products_Page();
	}
	
	public Products_Page clickOnCameras() throws InterruptedException, IOException
	{
		waitAndClickElement(button_cameras);
		return new Products_Page();
	}
	
	public String voucherCode() 
	{
		return vouchercode.getText();
	}
	
	public Products_Page clickOnProceed() throws InterruptedException, IOException
	{
		waitAndClickElement(button_Proceed_popup);
		return new Products_Page();
		
	}
		
	}


