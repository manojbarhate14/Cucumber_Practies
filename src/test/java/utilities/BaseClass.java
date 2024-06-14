package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	
	public static WebDriver lauchBrowser()
	{
		driver = WebDriverManager.chromedriver().create();
		return driver;
	}
	
	public static void takeScreenshot() throws IOException
	{
		File fromfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File tofile= new File("D:\\workspace\\cucumberPracties\\screenshots\\testcase.jpg");
		Files.copy(fromfile, tofile);
	}
	

}
