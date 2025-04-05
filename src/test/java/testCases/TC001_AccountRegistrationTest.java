package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegister;
import pageObject.HomePage;
import testbase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_account_registration() {
		logger.info("***** Starting TC001_AccountRegistrationTest****");
		logger.debug("This is a debug log message");
		try {
			HomePage hp = new HomePage(driver);

			hp.clickAccount();
			logger.info("Clicked on MyAccount Link.. ");
			hp.clickRegister();
			logger.info("Clicked on Register Link.. ");

			AccountRegister ar = new AccountRegister(driver);
			logger.info("Providing customer details...");
			ar.setFirstName(randomeString().toUpperCase());
			ar.setLastName(randomeString().toUpperCase());
			ar.setEmail(randomeString() + "@gmail.com");
			ar.setTelephone(randomeNumber());

			String pwd = randomAlphaNumeric();
			ar.setPassword(pwd);
			ar.setConfirmPassword(pwd);
			ar.setPrivacyPolicy();
			ar.clickContinue();

			logger.info("Validating expected message..");

			String cnfmsg = ar.getConirmationMsg();
			Assert.assertEquals(cnfmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

			logger.info("Test passed");
		} catch (Exception e) {
			logger.error("Test failed:" + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	}

}
