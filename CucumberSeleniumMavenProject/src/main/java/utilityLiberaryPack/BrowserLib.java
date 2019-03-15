package utilityLiberaryPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import customException.UnsupportedBrowserException;

public class BrowserLib {

	WebDriver driver;

	public BrowserLib(String browser) throws UnsupportedBrowserException {
		System.out.println("browser : " + browser);
		this.driver = setUpDriver(browser);
	}

	public WebDriver setUpDriver(String browser) throws UnsupportedBrowserException {

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			// driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {

		} else if (browser.equalsIgnoreCase("ie")) {

		} else {
			throw new UnsupportedBrowserException("invalid browser name");
		}

		return driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

}
