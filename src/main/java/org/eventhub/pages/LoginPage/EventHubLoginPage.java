package org.eventhub.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventHubLoginPage {

	public WebDriver driver;
	public EventHubLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login-btn")
	private WebElement login;
	
	public void performLogin(String emailId,String passcode) {
		email.sendKeys(emailId);
		password.sendKeys(passcode);
		login.click();
	}
	
}
