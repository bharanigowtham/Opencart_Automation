package oc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement btnMyacccount;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement btnRegister;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement btnlogin;

	public void myacclick() {
		btnMyacccount.click();
	}

	public void clickregister() {
		btnRegister.click();
	}
	
	public void clickLogin() {
		btnlogin.click();
	}
}
