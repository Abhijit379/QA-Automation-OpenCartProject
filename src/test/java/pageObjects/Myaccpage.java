package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccpage extends BasePage{
	
	public Myaccpage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement txtmyacc;

	public boolean myacctxt() {
		try {
			return txtmyacc.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		
		
	}
}
