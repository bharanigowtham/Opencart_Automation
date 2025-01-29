package oc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage {

	public Myaccountpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Orders']")
	WebElement btnMyorders;
	
	@FindBy(xpath="(//a[contains(text(),'Logout')])[2]")
	WebElement btnlogout;
	
	public boolean myAcclinkdisplaycheck() {
		try {
			return btnMyorders.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void ClickLogout() {
		btnlogout.click();
	}
}
