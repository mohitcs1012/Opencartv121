package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

/*
 * If data is valid-Login Successful-Test pass-Logout
 * If data is valid-Login failed-test failed.
 
 * If data is invalid-Login success-test fail-logout
 * If data is invalid-Login failed-test pass
 */

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "DataDriven", "Master" }) // getting
																													// data
																													// provider
																													// from
																													// different
																													// class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {
		logger.info("***** Starting TC003_LoginDDT****");

		try {
//			Home Page
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			hp.clickLogin();

//		Login Page
			LoginPage lp = new LoginPage(driver);
			lp.SetEmail(email);
			lp.SetPassword(pwd);
			lp.ClickLogin();

			MyAccountPage ap = new MyAccountPage(driver);
			boolean targetPage = ap.IsMyAccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {

				if (targetPage == true) {
					ap.ClickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			else if (exp.equalsIgnoreCase("Invalid")) {

				if (targetPage == true) {
					ap.ClickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}

			}
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		Thread.sleep(2000);

		logger.info("***** Finished TC003_LoginDDT****");
	}

}
