package testCases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
//import static org.testng.Assert.fail;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccpage;
import utilities.ExcelUtilities;

public class Login extends BaseClass{

	@Test(groups = {"Sanity","Master"})
	public void login() throws InterruptedException, IOException {
		try { 
			
			
			logger.info("******Home Page******");
			HomePage hp = new HomePage(driver);
			hp.myacc();
			hp.login();
			LoginPage log = new LoginPage(driver);
			
			
			logger.debug("Debug message");
			/*
			log.email(properties.getProperty("email"));
			log.password(properties.getProperty("password"));
			log.btnclick();
//			logger.trace("Trace message");
			Myaccpage acc = new Myaccpage(driver);
			boolean x = acc.myacctxt(true);
			
			assertTrue(x);
			
//			assertEquals(x, true);
 * 
			
			*/
			
			
			String filepath = System.getProperty("user.dir")+"\\testData\\testdatalogin.xlsx";
			ExcelUtilities ex = new ExcelUtilities();
			int row = ex.getrows(filepath, "Sheet1");
//			LoginPage log = new LoginPage(driver);
			Myaccpage acc = new Myaccpage(driver);
			/*
			String sheet = "Sheet1";
			for(int i = 1;i < row;i++) {
				String username = ex.getdata(filepath, sheet, i, 0);
				String password =  ex.getdata(filepath, sheet, i, 1);
				log.email(username);
				log.password(password);
				log.btnclick();
				log.clear();
				
			}
			*/
			
			
			
			
//			assertEquals(acc.myacctxt(true), true);
		} catch (Exception e) {
			Assert.fail();
		}
		
		
		
	
	}
}
