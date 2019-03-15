package stepsDefinationPack;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import customException.UnsupportedBrowserException;
import pageObjects.LoginPage;
import utilityLiberaryPack.BrowserLib;
import utilityLiberaryPack.PropertyFileUnitility;

public class Hooks {

	WebDriver driver;

	LoginPage loginPage;

	BrowserLib browserLib;

	@After(order = 1)
	public void afterScenerio() {
		driver.close();
	}

	@Before(order = 0)
	public void beforeScenerio1() throws UnsupportedBrowserException {

		String browser = System.getProperty("browser");
		String env = System.getProperty("env");
		if (browser == null || browser.isEmpty())
			browser = "chrome";

		if (env == null || env.isEmpty())
			env = "test";

		browserLib = new BrowserLib(browser);
		driver = browserLib.getDriver();
		
		System.out.println("current envrionment is : "+env);
		String url = PropertyFileUnitility.readPropertyFile("src/main/resources/environment/" + env + ".properties",
				"url");
		driver.get(url);
		loginPage = new LoginPage(driver);
		loginPage.login("username1", "password1");
		System.out.println("before every scenerio");
	}

	/*
	 * @Before("@regressionTest1") public void beforeScenerio1() {
	 * System.out.println("before  run only for regression Test scenerio"); }
	 * 
	 * @After("@regressionTest1") public void afterScenerio1() {
	 * System.out.println("after run only for regression Test scenerio"); }
	 */

}
