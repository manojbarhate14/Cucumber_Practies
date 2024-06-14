package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver ldriver;

	public AddCustomerPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href = '#'] //p[contains( text(),'Customers')]")
	WebElement customers;
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']")
    WebElement customerMenu;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement addcustomer;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstname;
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastname;
	@FindBy(id = "Gender_Male")
	WebElement gender;
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement dateofbirth;
	@FindBy(xpath = "//input[@id='Company']")
	WebElement company;
	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement taxexempt;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement role;
	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement comment;
	@FindBy(xpath = "//button[@name='save']")
	WebElement save;
	
	public void clickonCustomers()
	{
		customers.click();
	}
	public void clickonCustomersmenu()
	{
		customerMenu.click();
	}
	public void clickOnAddcustomer()
	{
		addcustomer.click();
	}
	public void enterEmail(String customeremail)
	{
		email.sendKeys(customeremail);
	}
	public void enterPass(String Password)
	{
		password.sendKeys(Password);
	}
	public void enterFirstName(String FirstName)
	{
		firstname.sendKeys(FirstName);
	}
	public void lastName(String LastName)
	{
		lastname.sendKeys(LastName);
	}
	public void selectGender()
	{
		gender.click();
	}
	public void dob(String DOB)
	{
		dateofbirth.sendKeys(DOB);
	}
	public void enterCompanyName(String CompanyName)
	{
		company.sendKeys(CompanyName);
	}
	public void clickOnTax()
	{
		taxexempt.click();
	}
	public void addComment(String AddComment)
	{
		comment.sendKeys(AddComment);
	}
	public void clickOnSave()
	{
		save.click();
	}
}
