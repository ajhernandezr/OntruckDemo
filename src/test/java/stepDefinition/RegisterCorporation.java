package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BusinessPage;
import pageObjects.CreateBusinessForm;
import pageObjects.MainPage;
import utility.pageObjectManager;
import utility.utilities;

public class RegisterCorporation {
	WebDriver driver;

	MainPage mainPageObject;
	BusinessPage businessPageObject;
	CreateBusinessForm 	createBusinessFormObject;
	pageObjectManager  pageObjectManagerObject;
	
	@Given("^I am on \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_am_on_with(String url, String browser) throws Throwable {
		// Start the driver
		utilities.selectBrowser(url,browser);
		driver = utilities.getDriver();
		pageObjectManagerObject = new pageObjectManager(driver);
		
		mainPageObject = pageObjectManagerObject.getMainPage();
		mainPageObject.getOnboardingPage();
		AssertJUnit.assertTrue(mainPageObject.getOnboardingPage().isDisplayed());
		
	}

	@When("^I navigate to business page$")
	public void i_navigate_to_business_page() throws Throwable {
	  mainPageObject.performHomePageOperation();
			  }

	@When("^proceed to Crear cuenta para empresa section$")
	public void proceed_to_Crear_cuenta_para_empresa_section() throws Throwable {
		businessPageObject = pageObjectManagerObject.getBusinessPage();
		AssertJUnit.assertTrue(businessPageObject.getOnboardingPage().isDisplayed());
		businessPageObject.performBusinessPageOperation();
	}

	@Then("^I get the create account form$")
	public void i_get_the_create_account_form() throws Throwable {
		createBusinessFormObject = pageObjectManagerObject.getCreateBusinessForm();
		
		createBusinessFormObject.getOnboardingPage();
	}

	@Then("^fill the form with the following \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void fill_the_form_with_the_following_and_and(String name, String email, String number) throws Throwable {
	   createBusinessFormObject.performFormOperation(name,email,number);
	}
	
}