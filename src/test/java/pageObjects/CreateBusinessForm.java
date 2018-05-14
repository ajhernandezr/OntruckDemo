package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import utility.utilities;

public class CreateBusinessForm {

	WebDriver driver;

	/// Web elements used

	@FindBy(xpath = ".//h2[text()='Crea tu cuenta en menos de un minuto']")

	WebElement formSection;

	@FindBy(id = "shipper-contact-name")

	WebElement formName;

	@FindBy(id = "shipper-contact-email")

	WebElement formMail;

	@FindBy(id = "shipper-contact-phone")

	WebElement formNumber;

	/// Strings for the report

	String reportPassed = "Business form performed correctly";
	String reportFailed = "Business form action failed";

	public CreateBusinessForm(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Check got to Main page

	public WebElement getOnboardingPage() {
		utilities.waitForElement(formSection);
		return formSection;

	}

	// Fill the form

	public void fillTheForm(String name, String email, String number) throws Exception {

		utilities.waitForElement(formName);
		formName.sendKeys(name);
		formMail.sendKeys(email);
		formNumber.sendKeys(number);
	}

	/**
	 * 
	 * This POM method will be used for perform the home page operations information
	 * 
	 * @param number
	 * @param email
	 * @param name
	 * 
	 * @param parameters
	 * @param scenario
	 * 
	 * @param testName
	 * @throws Exception
	 * 
	 * 
	 */

	public void performFormOperation(String name, String email, String number) throws Exception {

		try {

			// Go to the business page
			this.fillTheForm(name, email, number);
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