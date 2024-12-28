package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationForm extends BasePage{
	
	public AccountRegistrationForm(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txtfirstname;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txtlastname;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtemail;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txttelephone;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txtconfirm;
	@FindBy(xpath = "//input[@name='agree']") WebElement chkagree;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement txt;
	
	public void setFirstname(String fn) {
		txtfirstname.sendKeys(fn);
	}
	public void setlastname(String ln) {
		txtlastname.sendKeys(ln);
	}
	public void setemail(String em) {
		txtemail.sendKeys(em);
	}
	public void settelephone(String tel) {
		txttelephone.sendKeys(tel);
	}
	public void setpassword(String pas) {
		txtpassword.sendKeys(pas);
	}
	public void setconfirm(String pas) {
		txtconfirm.sendKeys(pas);
	}
	public void chkbox() {
		chkagree.click();
	}
	public void setContinue() {
		btnContinue.click();
	}
	public String txt() {
		
		return txt.getText();
	}
	
}
