package com.training.pom;

import org.apache.commons.codec.language.bm.Lang;
import org.apache.commons.codec.language.bm.Languages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sun.org.apache.xpath.internal.operations.And;

public class RegisterPOM {

	private WebDriver driver; 
	@FindBy(xpath="//a[contains(text(),'Sign up!')]")
	private WebElement Signup; 
	@FindBy(id="registration_firstname")
	private WebElement Firstname; 
	@FindBy(id="registration_lastname")
	private WebElement Lastname; 
	@FindBy(id="registration_email")
	private WebElement Email; 
	@FindBy(id="username")
	private WebElement Username; 
	@FindBy(id="pass1")
	private WebElement Password; 
	@FindBy(id="pass2")
	private WebElement Confmpass; 
	@FindBy(id="registration_phone")
	private WebElement phone; 
	//@FindBy(xpath="/html[1]/body[1]/main[1]/section[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/div[9]/div[1]/div[1]/button[1]/div[1]")
	//private WebElement Language;
	@FindBy(xpath="//p[contains(text(),'Teach courses')]")
	
			private WebElement Teacher;
	@FindBy(id="registration_submit")
	private WebElement Register;
	
	@FindBy(id="registration_language")
	private WebElement Register_lang;
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		
		
}
		public void Signup() {
			this.Signup.click(); 
		}
		
		public void enterFname(String Username) {
			this.Firstname.sendKeys(Username); 
		}
		public void enterLname(String Username) {
			this.Lastname.sendKeys(Username); 
		}
		public void enterEmail(String Username) {
			this.Email.sendKeys(Username); 
		}
		
		public void enterUsername(String Username) {
			this.Username.sendKeys(Username); 
		}
		
		public void enterPassword(String Username) {
			this.Password.sendKeys(Username); 
		}
		public void enterRePassword(String Username) {
			this.Confmpass.sendKeys(Username); 
		}
		public void enterPhone(String Username) {
			this.phone.sendKeys(Username); 
		}
		
	public void selectLang(String lang) throws Exception {
			
		//	Select drop = new Select(language);
		 //     drop.selectByVisibleText("English");
		
		   //  new Select(Engalish).selectByVisibleText("English");
		  this.Register_lang.click();
		   
        // Thread.sleep(2000);
		    //  Select stat=new Select(Register_lang);
		        //  stat.selectByVisibleText(lang);
     //   /html/body/main/section/div/div[2]/div/form/fieldset/div[9]/div[1]/div/div/div[2]/ul/li[17]/a
		     }

		
		public void selectTeacher() {
			this.Teacher.click();
		}
		
	public void Submitbutton() {
			this.Register.click(); 
		}
}

