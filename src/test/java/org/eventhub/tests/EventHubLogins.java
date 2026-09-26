package org.eventhub.tests;

import java.time.Duration;
import java.util.List;

import org.eventhub.bases.EventHubBase;
import org.eventhub.utils.AssertionsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventHubLogins extends EventHubBase {

	@Test
	public void scenarioOne() throws Exception {
		takeSnapshot("OnesHellos");
		loginPage.performLogin("", "Admin@12345");
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Enter a valid email");
	}

	@Test
	public void scenarioTwo() throws Exception {
		loginPage.performLogin("admin@gmail.com", "");
		Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Password must be at least 6 characters");
	}

	@Test
	public void RegistrationForm() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginPage.clickRegister();
		registerPage.register("", "Hello@12345", "Hello@12345");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Enter a valid email");
	}

	@Test
	public void RegistrationFormOne() throws Exception {
		loginPage.clickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		registerPage.register("Hello@123.com", "12", "12");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password does not meet the requirements below");
	}

	@Test
	public void successLogin() throws Exception {

		loginPage.performLogin("admin@gmail.com", "Admin@12345");
		dashboard.selectAdminDropdown("Manage Events");
		event.createNewEvent("Hellos", "Hellos", "Sports", "Hyd", "Hitech City", "10-11-2026", "08-22", "PM", "121",
				"100", "https://www.google.com");
	}

	@Test
	public void testName() throws Exception {
		loginPage.performLogin("admin@gmail.com", "Admin@12345");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dashboard.selectAdminDropdown("Manage Events");
		WebElement el = driver.findElement(By.xpath("(//button[text()='Edit'])[1]"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.elementToBeClickable(el)).click();
		editDashboard.clickDelete();
		
	}
}
