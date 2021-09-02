package storyLTD;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import resources.Base;
import storyLTD.pageObjects.HomePage;

public class Login extends Base {
	WebDriver driver = initializeDriver();
	String user = "mayur.vichare";
	String pass = "123456";
	HomePage home = new HomePage(driver);


	@BeforeSuite
	public void loginWithCredentials() throws IOException {

		home.clickHomePageLoginLink();
		home.enterLoginId(user);
		home.enterPassword(pass);
		home.clickSignIn();
		assertTrue((home.loggedinId().getText()).contains(user), "LoginID matched");
	}

	@AfterSuite
	public void loginWithoutCredentials() {

		home.loggedinId().click();
		home.logOut();
		assertTrue((home.loggedinId().getText()).contains(user), "LoginID did not matched");
		driver.quit();
	}
}
