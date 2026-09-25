package org.eventhub.pages.LoginDashboard;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventHubLoginDashboard {

	public WebDriver driver;
	public WebDriverWait wait;
	public EventHubLoginDashboard(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//div[@class='relative']")
	private WebElement adminDropdown;
	
	public void selectAdminDropdown(String name) {
		wait.until(ExpectedConditions.visibilityOf(adminDropdown)).click();
		List<WebElement>lists = driver.findElements(By.cssSelector("a.flex"));
		lists.stream().filter(p->p.getText().equalsIgnoreCase(name)).findFirst().ifPresent(p->p.click());
	}

}
