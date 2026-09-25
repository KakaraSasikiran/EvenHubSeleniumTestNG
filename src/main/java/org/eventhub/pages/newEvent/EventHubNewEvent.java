package org.eventhub.pages.newEvent;

import org.eventhub.common.utils.EventHubCommon;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EventHubNewEvent extends EventHubCommon {

	public EventHubNewEvent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

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
	@FindBy(id = "add-event-btn")
	private WebElement submit;
	public void createNewEvent(String titleName, String desc, String dropdownName, String cityName, String venue,
			String date, String time, String AM_PM,String price,String seats,String imgurl) {
		wait.until(ExpectedConditions.visibilityOf(titleField)).sendKeys(titleName);
		description.sendKeys(desc);
		selectDropdown(select_category, dropdownName);
		cityField.sendKeys(cityName);
		venueField.sendKeys(venue);
		calandarEvent.sendKeys(date);
		calandarEvent.sendKeys(Keys.TAB);
		calandarEvent.sendKeys(time);
		calandarEvent.sendKeys(AM_PM);
		priceField.sendKeys(price);
		totalSeats.sendKeys(seats);
		imageurl.sendKeys(imgurl);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('add-event-btn').click()");
	}

	private Select select;

	public Select selectDropdown(WebElement els, String name) {
		select = new Select(els);
		select.selectByVisibleText(name);
		return select;
	}

}
