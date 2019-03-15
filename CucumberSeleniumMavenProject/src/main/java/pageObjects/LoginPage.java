package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	WebDriverWait wait;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//*[@name='email']")
	private WebElement username;

	@FindBy(xpath = "//*[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//*[@id='signInSubmit']")
	private WebElement loginButton;

	@FindBy(xpath = "//*[@id='continue']")
	private WebElement continueButton;

	public void login(String uname, String pass) {
		username.sendKeys(uname);
		continueButton.click();
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
		loginButton.click();
	}

}
