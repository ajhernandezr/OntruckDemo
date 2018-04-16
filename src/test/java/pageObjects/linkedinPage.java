package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utility.utilities;

public class linkedinPage {

	WebDriver driver;

	/// Web elements used

	@FindBy(xpath = ".//div[@class='profile-overview-content ']/h1")

	WebElement name;

	@FindBy(xpath = ".//div[@class='profile-overview-content ']/p")

	WebElement currentJob;

	/// Strings for the report

	String reportPassed = "Linkedin page performed correctly";
	String reportFailed = "Linkedin page action failed";

	public linkedinPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Get actual Job

	public boolean getJob(String job) throws Exception {

		utilities.waitForElement(currentJob);
		String actualjob = currentJob.getText().toString();
		if (job.contains(actualjob) != true) {
			// Take screenshot
			utilities.reportScreenshots(reportFailed + " get job");

			// Log the info for the report

			utilities.logReports(reportFailed + " get job");
			return false;
		} else {
			// Take screenshot
			utilities.reportScreenshots(reportPassed + " luckyButton");

			// Log the info for the report

			utilities.logReports(reportPassed + " luckyButton");
			return true;
		}

	}
	// Get the Name

	public boolean getName(String applicantName) throws Exception {

		utilities.waitForElement(name);
		String webName = name.getText().toString();
		if (applicantName.contains(webName) != true) {
			// Take screenshot
			utilities.reportScreenshots(reportFailed + " get name");

			// Log the info for the report

			utilities.logReports(reportFailed + " get name");
			return false;
		} else {
			// Take screenshot
			utilities.reportScreenshots(reportPassed + " get name");

			// Log the info for the report

			utilities.logReports(reportPassed + " get name");
			return true;
		}

	}

}