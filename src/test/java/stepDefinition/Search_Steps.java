package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.googlePage;
import pageObjects.linkedinPage;
import utility.utilities;

public class Search_Steps {
	WebDriver driver;

	googlePage googlePageObject;
	linkedinPage linkedinPageObject;

	// Navigate and check get to the website
	@Given("^user is on \"([^\"]*)\" url with \"([^\"]*)\"$")
	public void user_is_on_url_with(String url, String browser) throws Throwable {
		utilities.selectBrowser(browser);
		driver = utilities.getDriver();
		googlePageObject = new googlePage(driver);
		utilities.navigateToUrl(url);
		AssertJUnit.assertTrue(utilities.getUrlTitle(url));
	}

	@When("^searching for \"([^\"]*)\"$")
	public void searching_for(String search) throws Throwable {

		googlePageObject.query(search);

	}

	@When("^pressing search button with \"([^\"]*)\"$")
	public void pressing_search_button_with(String user) throws Throwable {
		googlePageObject.searchButton();
		googlePageObject.selectUser(user);

	}

	@When("^pressing i'm feeling lucky button$")
	public void pressing_i_m_feeling_lucky_button() throws Throwable {
		googlePageObject.luckyButton();
	}

	@Then("^page opened should be \"([^\"]*)\"$")
	public void page_opened_should_be(String urlOpened) throws Throwable {
		AssertJUnit.assertTrue(utilities.getUrlTitle(urlOpened));
	}

	@Then("^the name should be \"([^\"]*)\"$")
	public void the_name_should_be(String applicantName) throws Throwable {
		AssertJUnit.assertTrue(linkedinPageObject.getName(applicantName));

	}

	@Then("^the current job should be \"([^\"]*)\"$")
	public void the_current_job_should_be(String job) throws Throwable {
		AssertJUnit.assertTrue(linkedinPageObject.getJob(job));

	}
}