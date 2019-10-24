package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.pom.ForgotPasswordPOM;
	import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class Register_ELTC_005 {
		
		private WebDriver driver;
		private String baseUrl;
		private RegisterPOM SignupPOM;
		private static Properties properties;
		private ScreenShot screenShot;
		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}
		  @BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.FIREFOX);
			SignupPOM = new RegisterPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		  }
	  

		  @Test
			public void validLoginTest() throws Exception {
			  SignupPOM.Signup();
			  SignupPOM.selectTeacher();
			  SignupPOM.enterFname("reva");

			//  String Expected = "manzoor mehadi";

		  
			  SignupPOM.enterLname("sharma");	  
			  SignupPOM.enterEmail("revasharma@gmail.com");	
			  SignupPOM.enterUsername("reva");
			  SignupPOM.enterPassword("reva321");
			  SignupPOM.enterRePassword("reva321");
			  SignupPOM.enterPhone("9876543210");
		//  SignupPOM.selectLang("Galego");
		 
			  SignupPOM.Submitbutton(); 
			  
			  String value= driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();
			  
			   Assert.assertEquals(value,"This login is already in use");
			   
			   System.out.println("Signup Test passed");
				screenShot.captureScreenShot("First");
			}


	}

