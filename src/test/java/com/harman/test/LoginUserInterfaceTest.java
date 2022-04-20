package com.harman.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.harman.base.WebDriverWrapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginUserInterfaceTest extends WebDriverWrapper {
	
	
	@Test
    
	public void validateTitleTest()
	{
			String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
		Reporter.log("validateTitleTest done- "+actualTitle);
		
		
		
		
	}
    


}
