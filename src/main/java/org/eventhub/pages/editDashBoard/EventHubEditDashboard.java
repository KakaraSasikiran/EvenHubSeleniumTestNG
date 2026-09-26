package org.eventhub.pages.editDashBoard;

import org.eventhub.common.utils.EventHubCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventHubEditDashboard extends EventHubCommon {

	public static JavascriptExecutor executor;

	public EventHubEditDashboard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id = "confirm-dialog-yes")
	private WebElement deleteEvent;
	public void clickEdit() {
		scriptExecutorClickEdit(driver);
	}

	public void clickDelete() {
		scriptExecutorClickDelete(driver);
		deleteEvent.click();
	}

	public static JavascriptExecutor scriptExecutorClickEdit(WebDriver driver) {
		executor = ((JavascriptExecutor) driver);
		executor.executeScript("document.getElementById('edit-event-btn').click()");
		return executor;
	}
	public static JavascriptExecutor scriptExecutorClickDelete(WebDriver driver) {
		executor = ((JavascriptExecutor)driver);
		executor.executeScript("document.getElementById('delete-event-btn').click()");
		return executor;
	}
	
}
