package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import storyLTD.pageObjects.HomePage;

public class Base {
	protected String path = System.getProperty("user.dir");

	public WebDriver initializeDriver() {

//		System.setProperty("webdriver.chrome.driver", path + "/src/main/java/resources/chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("headless");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to("https://beta.storyltd.in"); // beta site
		// driver.navigate().to("https://storyltd.com"); //live site

		HomePage home = new HomePage(driver);
		home.clickHomePagePopUpClose();

		return driver;
	}
}
