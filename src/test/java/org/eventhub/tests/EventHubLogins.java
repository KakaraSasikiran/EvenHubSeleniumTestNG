package org.eventhub.tests;

import org.eventhub.bases.EventHubBase;
import org.eventhub.utils.AssertionsUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EventHubLogins extends EventHubBase {

	@Test
	public void scenarioOne() throws Exception {
		takeSnapshot("OnesHellos");
		loginPage.performLogin("","Admin@12345");
		utils.assertText(By.xpath("//p[text()='Enter a valid email']"),"Enter a valid email");
	}
	@Test
	public void scenarioTwo() throws Exception {
		
	}
}
