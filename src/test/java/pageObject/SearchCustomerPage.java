package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;

public class SearchCustomerPage {

	WebDriver driver;

	public SearchCustomerPage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(id = "SearchEmail")
	WebElement searchfield;
	@FindBy(id = "search-customers")
	WebElement searchbtn;
	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement searchResult;
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	public void enterEmail(String email) {
		searchfield.sendKeys(email);
	}

	public void clickonsearchbtn() {
		searchbtn.click();
	}
	@Then("User should found {string} in the Search table")
	public void checkEmailIntable(String email) {
		// total no. of rows in a grid
		int ttlRows = tableRows.size();
		for (int i = 1; i < ttlRows; i++)// to iterate all the rows of the grid
		{
			WebElement webElementEmail = driver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			if (actualEmailAdd.equals(email)) {
				System.out.println("User "+actualEmailAdd+" found in table list");
			}
		}
	}
}
