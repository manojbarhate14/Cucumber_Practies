package stepdefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObject.AddCustomerPage;
import pageObject.LoginPageWithPageFactory;
import pageObject.SearchCustomerPage;
import utilities.BaseClass;

public class LoginFuntionSteps {
	// we have @Before,after,@Beforestep,@Afterstep hooks
	
	public WebDriver driver;
	public LoginPageWithPageFactory loginpg;
	AddCustomerPage add;
	SearchCustomerPage search;
	//Notes: if we have multiple before and after method we can set order or run by tag name
	
	@Before("@sanity") // before method by tag name
	public void setup1()
	{
		System.out.println("===>Before method by tag name");
	}
	@Before(order=1) // before method by execution order
	public void setup2()
	{
		System.out.println("===>Before method by order");
	}
	@BeforeStep
	public void beforestep()
	{
		System.out.println("===>Before step method execute before every step");
	}
	
	@Given("user launch chrome brouser")
	public void user_launch_chrome_brouser() throws IOException {
		driver = BaseClass.lauchBrowser();
		loginpg = new LoginPageWithPageFactory(driver);
		search= new SearchCustomerPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@When("user navigate to url {string}")
	public void user_navigate_to_url(String url) {
		driver.get(url);
	}

	@When("user enter email {string} and password {string}")
	public void user_enter_email_and_password(String email, String pass) {
		loginpg.enterEmail(email);
		loginpg.enterPassword(pass);
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		loginpg.clickOnLoginButton();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);//pass
		}
	}
	@When("user click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		Thread.sleep(2000);
		loginpg.clickOnLogOutButton();
	}
	@Then("close browser")
	public void close_browser(Scenario sc) throws IOException {
		if(sc.isFailed()==true)
	    {
	    	BaseClass.takeScreenshot();
	    }
		driver.close();
	}
	///////////////////////////////////ADD customer ///////////////////
	@Then("user can see the dashboard and click on csutomer menu")
	public void user_can_see_the_dashboard_and_click_on_csutomer_menu() {
	    add = new AddCustomerPage(driver);
	    add.clickonCustomers();
	    add.clickonCustomersmenu();
	}
	@When("click on add customer button")
	public void click_on_add_customer_button() {
	    add.clickOnAddcustomer();
	}
	@Then("user can view add cutomer page and enter the details")
	public void user_can_view_add_cutomer_page_and_enter_the_details() throws InterruptedException, IOException {
		BaseClass.takeScreenshot();
		add.enterEmail("admin@yourstore.com");
	    add.enterPass("admin");
	    add.enterFirstName("Admin");
	    add.lastName("Boss");
	    add.selectGender();
	    add.dob("14-05-1993");
	    add.enterCompanyName("HCLTech");
	    Thread.sleep(3000);
	    add.clickOnTax();
	    add.addComment("OK");
	   
	}
	@Then("click on save button")
	public void click_on_save_button() throws InterruptedException {
		Thread.sleep(2000);
	    add.clickOnSave();
	}
	@Then("user can see the confirmation message {string}")
	public void user_can_see_the_confirmation_message(String expect) {
	    System.out.println(expect);
	}
	// ====================================== search by email
	@When("Enter customer email {string}")
	public void enter_customer_email(String custemail) throws InterruptedException {
		Thread.sleep(2000);
	    search.enterEmail(custemail);
	}
	@When("Click on search button")
	public void click_on_search_button() {
	  search.clickonsearchbtn();
	}
	@Then("User should found {string} in the Search table")
	public void user_should_found_in_the_search_table(String email){
	    search.checkEmailIntable(email);
	}
	@After
	public void teardown()
	{
		System.out.println("Tear down after method");
	}
	@AfterStep
	public void afterstep()
	{
		System.out.println("===>After step method execute After every step");
	}
}
