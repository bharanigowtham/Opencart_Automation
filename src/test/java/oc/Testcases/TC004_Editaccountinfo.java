package oc.Testcases;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import oc.pageObjects.Homepage;
import oc.pageObjects.Loginpage;
import oc.pageObjects.Myaccountpage;

public class TC004_Editaccountinfo extends Baseclass {
	
	String telno;
	@Test(priority=0)
	public void TC004_editaccountinfo_telephone() throws InterruptedException {
		
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
		myaccountpage.clickEditaccountinfo();
		
		telno = randomnum();
		myaccountpage.telephonenoField(telno);
		System.out.println(telno);
		
		myaccountpage.clickContinue();
		Thread.sleep(1000);
		//Validation
		if(driver.getPageSource().contains("Success: Your account has been successfully updated")) {
			Assert.assertTrue(true);
			logger.info("Validation success...");
		}
		else {
			Assert.fail();
			logger.info("Validation failed...");
		}
	}

}	
