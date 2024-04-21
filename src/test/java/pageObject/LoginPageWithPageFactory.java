package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Page Object model with page factory
public class LoginPageWithPageFactory {

	WebDriver ldriver;

	public LoginPageWithPageFactory(WebDriver driver) {
		ldriver = driver;

	}

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement LoginBtn;

	@FindBy(linkText = "Logout")
	WebElement logout;

	public void enterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}

	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		LoginBtn.click();
	}

	public void clickOnLogOutButton() {
		logout.click();
	}
}
