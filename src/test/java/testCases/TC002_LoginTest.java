package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void verifyLogin()
	{
		logger.info("***** Starting TC002_LoginTest****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(p.getProperty("email"));
		lp.SetPassword(p.getProperty("password"));
		lp.ClickLogin();
		
		MyAccountPage ap=new MyAccountPage(driver);
		boolean targetPage=ap.IsMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC002_LoginTest****");
		
		
		
	}

}
