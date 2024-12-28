package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement myacc;
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement Register;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement log;
	public void myacc() {
		
		myacc.click();
	}  
	public void register() {
		Register.click();
	}
	
	public void login() {
		log.click();
	}
	
	
	
}
