package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPOM {
	
	private WebDriver driver; 
	@FindBy(xpath="//a[contains(text(),'I lost my password')]")
	private WebElement lostbutton; 
	@FindBy(id="lost_password_user")
	private WebElement Email; 
	@FindBy(id="lost_password_submit")
	private WebElement Submitbutton; 
	
	public ForgotPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
			
}
		public void lostbutton() {
			this.lostbutton.click(); 
		}
		
		public void enteremail(String Username) {
			this.Email.sendKeys(Username); 
		}
		
		
		public void Submitbutton() {
			this.Submitbutton.click(); 
		}
}
