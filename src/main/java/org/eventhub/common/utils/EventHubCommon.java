package org.eventhub.common.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventHubCommon {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public EventHubCommon(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
		PageFactory.initElements(driver, this);
		
	}

}
