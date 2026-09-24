package org.eventhub.tests;

import java.time.Duration;

import org.eventhub.bases.EventHubBase;
import org.eventhub.utils.AssertionsUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventHubLogins extends EventHubBase {

	@Test
	public void scenarioOne() throws Exception {
		takeSnapshot("OnesHellos");
		loginPage.performLogin("", "Admin@12345");
		Assert.assertEquals(loginPage.getEmailErrorMessage(),"Enter a valid email");
	}

	@Test
	public void scenarioTwo() throws Exception {
		loginPage.performLogin("admin@gmail.com", "");
		Assert.assertEquals(loginPage.getPasswordErrorMessage(),"Password must be at least 6 characters");
	}
	@Test
	public void RegistrationForm() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginPage.clickRegister();
		registerPage.register("","Hello@12345","Hello@12345");
		Assert.assertEquals(registerPage.getEmailErrorMessage(),"Enter a valid email");
	}
}
