package oc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends Basepage {

	public Accountregistrationpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;


	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;


	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;


	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmpaswd;


	@FindBy(xpath="//input[@name='agree']")
	WebElement chkprivacypolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContiue;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement successmsg;

	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pswd) {
		txtPassword.sendKeys(pswd);
	}
	
	public void setConfirmpaswd(String confpswd) {
		txtConfirmpaswd.sendKeys(confpswd);
	}
	
	public void clickAgreechkbox() {
		chkprivacypolicy.click();
	}
	
	public void clickcontinuebtn() {
		btnContiue.click();
	}
	
	public String getconfirmationmessg() {
		try {
			return(successmsg.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
}
