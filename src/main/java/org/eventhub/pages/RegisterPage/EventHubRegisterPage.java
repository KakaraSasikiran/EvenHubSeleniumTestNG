package org.eventhub.pages.RegisterPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventHubRegisterPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public EventHubRegisterPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "register-email")
	private WebElement email;
	
	@FindBy(id = "register-password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@placeholder='Repeat your password']")
	private WebElement confirmpasswords;
	@FindBy(id = "register-btn")
	private WebElement registerBtn;
	public void register(String emailId,String passwords,String confirmPasswords) {
		email.sendKeys(emailId);
		password.sendKeys(passwords);
		confirmpasswords.sendKeys(confirmPasswords);
		registerBtn.click();
	}
	@FindBy(xpath = "//p[text()='Enter a valid email']")
	private WebElement emailidErrorMessage;
	@FindBy(xpath = "//p[text()='Password does not meet the requirements below']")
	private WebElement passwordErrorMessage;
	@FindBy(xpath = "Passwords do not match")
	private WebElement passwordnotmatchErrorMessage;
	
	public String getEmailErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOf(emailidErrorMessage)).getText();
	}
	public String getPasswordErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOf(passwordErrorMessage)).getText();
	}
	public String getConfirmPasswordErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOf(passwordnotmatchErrorMessage)).getText();
	}
	
}
