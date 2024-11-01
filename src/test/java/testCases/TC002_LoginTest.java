package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Baseclass;

public class TC002_LoginTest {
	
	public class TC0002_LoginTest extends Baseclass{
		
		@Test(groups= {"Sanity", "Master"})
		public void verify_login() 
		{
			logger.info("****** Starting TC002_LoginTest ******");
			
			try
			{
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			//Assert.assertEquals(targetPage, true,"Login failed");
			Assert.assertTrue(targetPage);
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			logger.info("****** Finished TC002_LoginTest ******");
		}
	}

}