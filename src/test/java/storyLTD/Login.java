package storyLTD;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;
import resources.ScreenShotClass;
import storyLTD.pageObjects.HomePage;

public class Login extends Base {
	WebDriver driver = initializeDriver();
	String user = "mayur.vichare";
	String pass = "123456";
	HomePage home = new HomePage(driver);
	ScreenShotClass sc = new ScreenShotClass();

	@Test
	public void loginWithCredentials() throws IOException {

		home.clickHomePageLoginLink();
		home.enterLoginId(user);
		home.enterPassword(pass);
		home.clickSignIn();
		assertTrue((home.getLoginId()).contains(user), "LoginID matched");
		// String name = new Object(){}.getClass().getEnclosingMethod().getName();
		// sc.takeScreenShot(driver, name);
	}

	@Test
	public void loginWithoutCredentials() {

		home.clickHomePageLoginLink();
		home.clickSignIn();
		//assertTrue((home.getLoginId()).contains(user), "LoginID did not matched");
	}
}
