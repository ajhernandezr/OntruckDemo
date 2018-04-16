package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utility.utilities;

public class googlePage {

	WebDriver driver;

	/// Web elements used

	@FindBy(id = "lst-ib")

	WebElement searchField;

	@FindBy(xpath = ".//input[@value='Voy a tener suerte' and @name='btnI']")

	WebElement luckyButton;

	@FindBy(xpath = ".//input[@value='Buscar con Google']")

	WebElement searchButton;

	/// Strings for the report

	String reportPassed = "Google page performed correctly";
	String reportFailed = "Google page action failed";

	public googlePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Perform a query

	public void query(String search) throws Exception {

		utilities.waitForElement(searchField);
		searchField.sendKeys(search);
		// Take screenshot
		utilities.reportScreenshots(reportPassed + " query");

		// Log the info for the report

		utilities.logReports(reportPassed + " query");
	}
	// Press the voy a tener suerte button

	public void luckyButton() throws Exception {

		utilities.waitForElement(luckyButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", luckyButton);

		// Take screenshot
		utilities.reportScreenshots(reportPassed + " luckyButton");

		// Log the info for the report

		utilities.logReports(reportPassed + " luckyButton");
	}

	// Press the search button

	public void searchButton() throws Exception {

		utilities.waitForElement(searchButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", searchButton);

	}

	// Select the User

	public void selectUser(String user) throws Exception {

		driver.findElement(By.xpath(".//a[contains(@ping,'" + user + "')]")).click();
		;

		// Take screenshot
		utilities.reportScreenshots(reportPassed + " selectUser");

		// Log the info for the report

		utilities.logReports(reportPassed + " selectUser");

		
	}
}