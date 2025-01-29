package oc.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import oc.Utilities.DataProviders;
import oc.pageObjects.Homepage;
import oc.pageObjects.Loginpage;
import oc.pageObjects.Myaccountpage;

public class TC003_LogintestDDT extends Baseclass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"Sanity", "Datadriven"})
	public void logintestDDT(String email, String pswd, String res) {
		
		logger.info("*********Starting TC003_Login Data driven test **********");
		try {
		Homepage homepage = new Homepage(driver);
		homepage.myacclick();
		homepage.clickLogin();

		Loginpage loginpage = new Loginpage(driver);
		loginpage.clickLogin();

		loginpage.enterEmail(email);
		loginpage.enterPassword(pswd);
		loginpage.clickLogin();

		Myaccountpage myaccountpage = new Myaccountpage(driver);
		boolean sts = myaccountpage.myAcclinkdisplaycheck();
		
		if(res.equalsIgnoreCase("valid"))
		{
			if(sts==true) {
				Assert.assertTrue(true);
				myaccountpage.ClickLogout();
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(res.equalsIgnoreCase("invalid")) {
			if(sts==true) {
				myaccountpage.ClickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		} }
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*********Completed TC003_Login Data driven test **********");

	}
}
