package com.harman.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.harman.base.WebDriverWrapper;

public class LoginTest extends WebDriverWrapper {

	@Test
	public void validCredentialTest() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	

	@Test(dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username, String password, String expectedError) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());

		String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualError, expectedError);
	}

} 