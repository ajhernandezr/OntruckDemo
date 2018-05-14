package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class utilities {
	public static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	public static void setWebDriver(WebDriver driver) {
		webDriver.set(driver);
	}

	public static void smallPause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Handle here
		}
	}

	public static void mediumPause() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// Handle here
		}
	}

	public static void longPause() {
		try {
			Thread.sleep(14000);
		} catch (InterruptedException e) {
			// Handle here
		}
	}

	public static void waitForElement(WebElement element) {
		driver = utilities.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitUntilElementDisplayed(final WebElement webElement) {

		driver = utilities.getDriver();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisplayed);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void navigateToUrl(String url) {
		utilities.getDriver();
		driver.get(url);
	}

	public static boolean getUrlTitle(String url) {
		utilities.mediumPause();
		String actualTitle = driver.getCurrentUrl().toString();
		if (actualTitle.contains(url) != true) {
			return false;
		} else {
			return true;
		}
	}

	public static void moveToElement(WebElement element) {

		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}

	public static WebDriver selectBrowser(String url,String browser) {
		
		switch (browser) {
		case "Firefox":

			System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");

			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			
			driver.get(url);
			break;
	
		case "chrome":
			// Create a new instance of the Chrome driver

			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();

			// Disable extensions and hide infobars
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

			driver.get(url);
			break;
		}
		utilities.setWebDriver(driver);
			return driver;
		}
		
	

	// Method for interact with dificult web elements
	public static void pushDificultElements(WebDriver driver, final WebElement element2) throws Exception {
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		Function<WebDriver, WebElement> push = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver arg0) {
				WebElement element = element2;
				if (element != null) {

					element.click();
				}
				return element;
			}
		};
		fluent.until(push);
	}

	/// Configure the Extent Reports
	public static void runReports(String testName) throws Exception {

		/// Configure the Extent Reports
		report = new ExtentReports("./src/main/resources/extentReports/" + testName + ".html", true);
		report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

		logger = report.startTest(testName);
		logger.log(LogStatus.PASS, "LAUNCHING TEST CASE " + testName);

	}

	/// Log one step for the report
	public static void logReports(String logInfo) throws Exception {

		logger.log(LogStatus.PASS, logInfo);

	}

	/// Close the reports
	public static void closeReports() throws Exception {
		report.endTest(logger);
		report.flush();
		report.close();

	}

	// Getting Screenshot for evidences
	public static void reportScreenshots(String step) throws Exception {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File(Constant.Screenshot_Passed_Path + step + ".jpg"));
	}
	// Getting Screenshot for failed evidences
		public static void reportFailedScreenshots(String step) throws Exception {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(Constant.Screenshot_Error_Path + step + ".jpg"));
		}
}
