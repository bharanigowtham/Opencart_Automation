package oc.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import oc.pageObjects.Homepage;
import oc.pageObjects.Loginpage;
import oc.pageObjects.Myaccountpage;

public class TC005_Validateorderhistory extends Baseclass {

	@Test()
	public void TC005Validateorderhistory() throws InterruptedException {

		logger.info("Starting TC004_editaccountinfo_telephone ");
		Homepage homepage = new Homepage(driver);
		homepage.myacclick();
		homepage.clickLogin();

		Loginpage loginpage = new Loginpage(driver);
		loginpage.clickLogin();

		loginpage.enterEmail(prop.getProperty("username"));
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickLogin();

		Myaccountpage myaccountpage = new Myaccountpage(driver);
		myaccountpage.clickOrderhistory();
		if(driver.getPageSource().contains("You have not made any previous orders!")) {
			
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
	}

}
