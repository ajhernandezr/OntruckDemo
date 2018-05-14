package utility;


import org.openqa.selenium.WebDriver;

import pageObjects.MainPage;

import pageObjects.BusinessPage;

import pageObjects.CreateBusinessForm;


public class pageObjectManager {

	private WebDriver driver;

	private MainPage MainPage;

	private BusinessPage BusinessPage;

	private CreateBusinessForm CreateBusinessForm;


	

	public pageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	

	public MainPage getMainPage(){

		return (MainPage == null) ? MainPage = new MainPage(driver) : MainPage;

	}

	

	public BusinessPage getBusinessPage() {

		return (BusinessPage == null) ? BusinessPage = new BusinessPage(driver) : BusinessPage;

	}

	

	public CreateBusinessForm getCreateBusinessForm() {

		return (CreateBusinessForm == null) ? CreateBusinessForm = new CreateBusinessForm(driver) : CreateBusinessForm;

	}

	

	
}