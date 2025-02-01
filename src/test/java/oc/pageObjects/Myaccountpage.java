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
	
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	WebElement editaccountinfo;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephoneno;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//a[normalize-space()='View your order history']")
	WebElement ordrhistory;
	
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
	
	public void clickEditaccountinfo() {
		
		editaccountinfo.click();
	}
	
	public void telephonenoField(String newTelno) {
		telephoneno.clear();		
		telephoneno.sendKeys(newTelno);
	}
	
	public void clickContinue() {
		continuebtn.click();
	}
	
	public String get_telephoneno() throws InterruptedException {
		telephoneno.click();
		Thread.sleep(2000);
		
		String actualtelNo=telephoneno.getAttribute("innerHTML");
		System.out.println(actualtelNo);
		return actualtelNo;
//		System.out.println(telephoneno.getText());
	}	
	
	public void clickOrderhistory() {
		
		ordrhistory.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
