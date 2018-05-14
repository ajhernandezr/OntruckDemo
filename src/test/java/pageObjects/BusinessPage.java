package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import utility.utilities;

public class BusinessPage {

	WebDriver driver;

	/// Web elements used

	@FindBy(xpath = ".//h1[text()='ONTRUCK para empresas']")

	WebElement onboardingSection;

	@FindBy(xpath = ".//a[@title='Crear cuenta para empresa']")

	WebElement businessAccountButton;

	
	/// Strings for the report

	String reportPassed = "Business page performed correctly";
	String reportFailed = "Business page action failed";

	public BusinessPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Check got to Main page

	public WebElement getOnboardingPage() {
		utilities.waitForElement(onboardingSection);
		return onboardingSection;

	}

	// Navigate to Create Business Account Form

	public void navigateBusinessForm() throws Exception {

		utilities.waitForElement(businessAccountButton);
		businessAccountButton.click();

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

	public void performBusinessPageOperation() throws Exception {

		try {

			// Go to the business page
			this.navigateBusinessForm();
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