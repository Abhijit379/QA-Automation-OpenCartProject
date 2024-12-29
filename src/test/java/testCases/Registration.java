package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationForm;
import pageObjects.HomePage;

public class Registration  extends BaseClass{
	
	@Test(groups = {"Regression","Master"})
	public void registration() {
		
		try {
			HomePage homePage = new HomePage(driver);
			logger.info("Test Started");
			homePage.myacc();
			homePage.register();
			
			AccountRegistrationForm acg = new AccountRegistrationForm(driver);
			acg.setFirstname(randamString().toUpperCase());
			acg.setlastname(randamString().toUpperCase());
			acg.setemail(randamString()+"@gmail.com");
			acg.settelephone(randomint());
			String pas = afphanum();
			acg.setpassword(pas);
			acg.setconfirm(pas);
			acg.chkbox();
//			Thread.sleep(5000);
			acg.setContinue();
			if (acg.txt().equals("Your Account Has Been Created!")) {
				
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test Failed");
				logger.debug("Test Debug logs");
				Assert.fail();
			}
		} catch (Exception e) {
			
		
			Assert.fail();
		}
		
		
	}
	
	
}
