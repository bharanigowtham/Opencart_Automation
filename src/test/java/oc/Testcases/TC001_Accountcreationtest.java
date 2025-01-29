package oc.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import oc.pageObjects.Accountregistrationpage;
import oc.pageObjects.Homepage;

public class TC001_Accountcreationtest extends Baseclass {

	@Test(groups = {"Master","Regression"})
	public void TC001_validateaccountcreationtest() {
		try {
		logger.info("****Starting TC001_validateaccountcreationtest ****");
		
		Homepage hp = new Homepage(driver);
		hp.myacclick();
		hp.clickregister();
		logger.info("----Registration menu clicked----");
		Accountregistrationpage accreg = new Accountregistrationpage(driver);
		accreg.setFirstname(randomstring());
		accreg.setLastname(randomstring());
		accreg.setEmail(randomstring()+ "@gmail.com");
		accreg.setTelephone(randomnum());
		String password = randomalphanum();
		accreg.setPassword(password);
		accreg.setConfirmpaswd(password);
		accreg.clickAgreechkbox();
		accreg.clickcontinuebtn();
		logger.info("----Success message validation ----");

		String succmsg = accreg.getconfirmationmessg();
		Assert.assertEquals(succmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			logger.debug("#### This is debug logs ####");
			Assert.fail();
		}
		logger.info("****Completed TC001_validateaccountcreationtest ****");
	}
}
