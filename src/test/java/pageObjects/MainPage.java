package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import utility.utilities;

public class MainPage {

	WebDriver driver;

	/// Web elements used

	@FindBy(xpath = ".//section[@class='section __section-home-main']")

	WebElement onboardingSection;

	@FindBy(xpath = ".//a[@title='OnTruck para empresas' and @class ='btn secondary']")

	WebElement businessButton;

	
	/// Strings for the report

	String reportPassed = "Main page performed correctly";
	String reportFailed = "Main page action failed";

	public MainPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Check got to Main page

	public WebElement getOnboardingPage() {
		utilities.waitForElement(onboardingSection);
		return onboardingSection;

	}

	// Navigate to Business Page

	public void navigateBusiness() throws Exception {

		utilities.waitForElement(businessButton);
		businessButton.click();

	}

	/**
	 * 
	 * This POM method will be used for perform the home page operations information
	 * 
	 * @param parameters
	 * @param scenario
	 * 
	 * @param testName
	 * @throws Exception
	 * 
	 * 
	 */

	public void performHomePageOperation() throws Exception {

		try {

			// Go to the business page
			this.navigateBusiness();
			// Take screenshot
			utilities.reportScreenshots(reportPassed);

			// Log the info for the report

			utilities.logReports(reportPassed);
		} catch (Exception e) {
			// Take screenshot
			utilities.reportScreenshots(reportFailed);
			throw (e);
		}
	}
}