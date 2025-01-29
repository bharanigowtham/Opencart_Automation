package oc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {

	public Loginpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath=" //input[@value='Login']")
	WebElement btnLogin;
	
	public void enterEmail(String uname) {
		txtEmail.sendKeys(uname);
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();		
	}
	

}
