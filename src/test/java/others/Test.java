package others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddCustomerPage;

public class Test {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = WebDriverManager.chromedriver().create();
		AddCustomerPage add= new AddCustomerPage(driver);
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2FAdmin");
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		Thread.sleep(3000);
		add.clickonCustomers();
		add.clickonCustomersmenu();
		add.clickOnAddcustomer();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='select2-selection__choice__remove']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--focus select2-container--above']//span[@class='selection']//ul[@class='select2-selection__rendered']"));
		dropdown.click();
		Thread.sleep(3000);
		Select select= new Select(dropdown);
		String str= select.getAllSelectedOptions().toString();
		System.out.println(str);
		
		

	}

}
