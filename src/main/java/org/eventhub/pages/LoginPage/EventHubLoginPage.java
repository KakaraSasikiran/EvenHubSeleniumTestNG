package org.eventhub.pages.LoginPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventHubLoginPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public EventHubLoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login-btn")
	private WebElement login;
	@FindBy(xpath = "//p[text()='Password must be at least 6 characters']")
	private WebElement passwordErrorMessage;
	@FindBy(xpath = "//p[text()='Enter a valid email']")
	private WebElement emailErrorMessage;
	@FindBy(linkText = "Register")
	private WebElement register;
	public void performLogin(String emailId,String passcode) {
		email.sendKeys(emailId);
		password.sendKeys(passcode);
		login.click();
	}
	
	public String getPasswordErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOf(passwordErrorMessage)).getText();
	}
	public String getEmailErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOf(emailErrorMessage)).getText();
	}
	public void clickRegister() {
		register.click();
	}
	
}
