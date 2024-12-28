package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccpage;
import utilities.DataProviders;

public class LoginDataProvider extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "Data Driven")
	public void dataprovider(String a, String b, String c)
	{
		try {
			logger.info("******Home Page******");
			HomePage hp = new HomePage(driver);
			hp.myacc();
			hp.login();
			LoginPage log = new LoginPage(driver);
			logger.debug("Debug message");
			log.email(a);
			log.password(b);
			log.btnclick();
			Myaccpage acc = new Myaccpage(driver);
			boolean x = acc.myacctxt();
			if (c.equalsIgnoreCase("valid")) {
				if (x==true) {
					log.logout();
					Assert.assertTrue(true);	
				}
				else {
					Assert.assertTrue(false);
				}
			}
			if (c.equalsIgnoreCase("invalid")) {
				if (x==true) {
					log.logout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			
			Assert.fail();
		}
	}
}
