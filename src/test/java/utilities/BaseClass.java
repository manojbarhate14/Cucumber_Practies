package utilities;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	
	public static WebDriver lauchBrowser()
	{
		driver = WebDriverManager.chromedriver().create();
		return driver;
	}
	
	

}
