package org.eventhub.bases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.eventhub.pages.LoginDashboard.EventHubLoginDashboard;
import org.eventhub.pages.LoginPage.EventHubLoginPage;
import org.eventhub.pages.RegisterPage.EventHubRegisterPage;
import org.eventhub.pages.editDashBoard.EventHubEditDashboard;
import org.eventhub.pages.newEvent.EventHubNewEvent;
import org.eventhub.utils.AssertionsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EventHubBase {

	public static Properties properties;
	public static File file;
	public static FileInputStream fileInputStream;
	public static WebDriver driver;
	public static EventHubLoginPage loginPage;
	public static AssertionsUtils utils;
	public static EventHubRegisterPage registerPage;
	public static EventHubLoginDashboard dashboard;
	public static EventHubNewEvent event;
	public static EventHubEditDashboard editDashboard;
	@BeforeSuite
	public void inits() {
		optBrowser("one");
	}
	public static Properties getPropertiesData(String fileName) {
		
		properties = new Properties();
		file = new File(System.getProperty("user.dir")+"//src//resources//java//properties//"+fileName+".properties");
		try {
			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	public static WebDriver optBrowser(String fileName) {
		if (getPropertiesData(fileName).getProperty("browser").toLowerCase().equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(getPropertiesData(fileName).getProperty("browser").toLowerCase().equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(getPropertiesData(fileName).getProperty("browser").toLowerCase().equals("msedge")) {
			driver = new EdgeDriver();
		}
		else {
			System.err.println("Check once Details!");
		}
		driver.get(getPropertiesData(fileName).getProperty("url"));
		commonDrivers(driver);
		return driver;
	}
	public static WebDriver commonDrivers(WebDriver driver) {
		loginPage = new EventHubLoginPage(driver);
		utils = new AssertionsUtils(driver);
		registerPage = new EventHubRegisterPage(driver);
		dashboard = new EventHubLoginDashboard(driver);
		event = new EventHubNewEvent(driver);
		editDashboard = new EventHubEditDashboard(driver);
		return driver;
	}
	public void takeSnapshot(String imageName) {
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dsc = new File(System.getProperty("user.dir")+"//src//resources//java//images//"+imageName+".png");
		try {
			FileUtils.copyFile(src, dsc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
