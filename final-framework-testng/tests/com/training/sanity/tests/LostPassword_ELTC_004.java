package com.training.sanity.tests;

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LostPassword_ELTC_004 {
	
	private WebDriver driver;
	private String baseUrl;
	private ForgotPasswordPOM PasswordPOM;
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
		PasswordPOM = new ForgotPasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	  }
  

	  @Test
		public void validLoginTest() {
		  PasswordPOM.lostbutton();
		  PasswordPOM.enteremail("admin");
		  PasswordPOM.Submitbutton(); 
		  
		  String value= driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		  
		   Assert.assertEquals(value,"This platform was unable to send the email. Please contact Site Owner for more information.");
		   
		   System.out.println("LostPaasword Test passed");
		
		  
			screenShot.captureScreenShot("First");
		}

  @AfterMethod
  public void afterMethod() {
  }

  

}
