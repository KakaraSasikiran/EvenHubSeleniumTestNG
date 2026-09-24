package org.eventhub.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertionsUtils {
	public WebDriver driver;
	public AssertionsUtils(WebDriver driver) {
		this.driver=driver;
	}
	public void assertText(By ele,String validationText) {
		String str = driver.findElement(ele).getText();
		Assert.assertEquals(str,validationText);
	}
}
