package pageObjects;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement email;
	@FindBy(xpath = "//input[@id='input-password']") WebElement password;
	@FindBy(xpath = "//input[@value='Login']") WebElement btnlogin;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btnlogout;
	@FindBy(xpath = "//a[normalize-space()='Continue']") WebElement btncontinue;
	public void email(String usr) {
		email.sendKeys(usr);
	}
	public void password(String pas) {
		password.sendKeys(pas);
	}
	public void btnclick() {
		btnlogin.click();
	}
	public void clear() {
		email.clear();
		password.clear();
	}
	public void logout() {
		btnlogout.click();
		btncontinue.click();
	}

	

}
