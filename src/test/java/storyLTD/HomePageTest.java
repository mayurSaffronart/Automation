package storyLTD;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.base;
import storyLTD.pageObjects.HomePage;

public class HomePageTest extends base {
	WebDriver driver = initializeDriver();
	
	@Test
	public void random()
	{
		HomePage home = new HomePage(driver);
		home.enterText().sendKeys("mayur");
		home.signUp();
		
		
	}

}
