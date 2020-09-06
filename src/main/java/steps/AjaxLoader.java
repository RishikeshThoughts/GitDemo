package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class AjaxLoader extends DriverFactory{
	
	WebDriverWait wait = new WebDriverWait(getDriver(),20);

	@Given("^I login to WebDriver University Ajax portal$")
	public void i_login_to_WebDriver_University_Ajax_portal() throws Throwable {
	    getDriver().get("http://www.webdriveruniversity.com/Ajax-Loader/index.html");
	}

	@And("^I click on CLICK ME button after waiting$")
	public void i_click_on_CLICK_ME_button_after_waiting() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("alert('HEllo ALert generated')");
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		al.accept();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'CLICK ME!')]")));
		element.click();
	    Thread.sleep(3000);
	}

	
	
}
