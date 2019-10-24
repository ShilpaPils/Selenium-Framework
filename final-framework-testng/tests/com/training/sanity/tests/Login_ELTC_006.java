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
import com.training.pom.LoginElaringPOM;
import com.training.pom.LoginPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class Login_ELTC_006 {

		private WebDriver driver;
		private String baseUrl;
		private LoginElaringPOM LoginPOM;
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
			LoginPOM = new LoginElaringPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		
		@Test
		public void validLoginTest() {
			LoginPOM.sendUserName("reva");
			LoginPOM.sendPassword("reva321");
			LoginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");

		String value= driver.findElement(By.xpath("//li[@class='active']")).getText();
			  
			   Assert.assertEquals(value,"My courses");
			   
			   System.out.println("Login Test passed");
		}
	}