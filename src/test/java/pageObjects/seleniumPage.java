package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utility.utilities;

public class seleniumPage {

	WebDriver driver;

	/// Web elements used


	

	public seleniumPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}




	
}