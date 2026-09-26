package org.eventhub.pages.editDashBoard;

import org.eventhub.common.utils.EventHubCommon;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EventHubEditDashboard extends EventHubCommon {

	public static JavascriptExecutor executor;
	public static Select select;
	@FindBy(css = "input[id='event-title-input']")
	private WebElement titleField;

	@FindBy(css = "textarea[placeholder='Describe the event…']")
	private WebElement description;

	@FindBy(id = "category")
	private WebElement select_category;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "venue")
	private WebElement venueField;

	@FindBy(id = "event-date-&-time")
	private WebElement calandarEvent;

	@FindBy(id = "price-($)")
	private WebElement priceField;

	@FindBy(id = "total-seats")
	private WebElement totalSeats;

	@FindBy(id = "image-url-(optional)")
	private WebElement imageurl;

	public EventHubEditDashboard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "confirm-dialog-yes")
	private WebElement deleteEvent;
	@FindBy(id = "add-event-btn")
	private WebElement updateBtn;

	public void clickEdit() {
		scriptExecutorClickEdit(driver);
	}

	public void clickDelete() {
		scriptExecutorClickDelete(driver);
		deleteEvent.click();
	}
	public Select selectDropdown(WebElement els, String name) {
		select = new Select(els);
		select.selectByVisibleText(name);
		return select;
	}
	public void updateNewEvent(String titleName, String desc, String dropdownName, String cityName, String venue,
			String date, String time, String AM_PM,String price,String seats,String imgurl) {
		wait.until(ExpectedConditions.visibilityOf(titleField)).sendKeys(titleName);
		description.sendKeys(desc);
		selectDropdown(select_category, dropdownName);
		cityField.clear();
		cityField.sendKeys(cityName);
		venueField.clear();
		venueField.sendKeys(venue);
		calandarEvent.clear();
		calandarEvent.sendKeys(date);
		calandarEvent.sendKeys(Keys.TAB);
		calandarEvent.sendKeys(time);
		calandarEvent.sendKeys(AM_PM);
		priceField.clear();
		priceField.sendKeys(price);
		totalSeats.clear();
		totalSeats.sendKeys(seats);
		imageurl.clear();
		imageurl.sendKeys(imgurl);
		scriptExecutorupdateBtn(driver);
		
	}

	public static JavascriptExecutor scriptExecutorClickEdit(WebDriver driver) {
		executor = ((JavascriptExecutor) driver);
		executor.executeScript("document.getElementById('edit-event-btn').click()");
		return executor;
	}

	public static JavascriptExecutor scriptExecutorClickDelete(WebDriver driver) {
		executor = ((JavascriptExecutor) driver);
		executor.executeScript("document.getElementById('delete-event-btn').click()");
		return executor;
	}
	public static JavascriptExecutor scriptExecutorupdateBtn(WebDriver driver) {
		executor = ((JavascriptExecutor) driver);
		executor.executeScript("document.getElementById('add-event-btn').click()");
		return executor;
	}

	

}
