
package utility;
 
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utility.utilities;
 
public class Hooks {
	WebDriver driver;

	@Before
	public void beforeScenario(Scenario scenario) throws Exception {
		
		utilities.runReports(scenario.getName());
		
	}
	
	
	// Close the driver after the test is done
		@After
		public void AfterSteps() throws Exception {
			utilities.getDriver().quit();
			utilities.closeReports();
		}

	
	
 
}