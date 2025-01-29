package oc.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import oc.pageObjects.Homepage;
import oc.pageObjects.Loginpage;
import oc.pageObjects.Myaccountpage;

public class TC002_Logintest extends Baseclass {

	@Test(groups = {"Sanity","Master"})
	public void TC002_logintest() {

		logger.info("****Starting TC002_logintest*****");
		try {
			Homepage homepage = new Homepage(driver);
			homepage.myacclick();
			homepage.clickLogin();

			Loginpage loginpage = new Loginpage(driver);
			loginpage.clickLogin();

			loginpage.enterEmail(prop.getProperty("username"));
			loginpage.enterPassword(prop.getProperty("password"));
			loginpage.clickLogin();

			Myaccountpage myaccountpage = new Myaccountpage(driver);
			boolean sts = myaccountpage.myAcclinkdisplaycheck();
			Assert.assertEquals(sts, true, "Login failed");
		} 
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("****Completed TC002_logintest*****");

	}

}
