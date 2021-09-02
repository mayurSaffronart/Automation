package storyLTD;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class HomePageTest extends Base {
	WebDriver driver = initializeDriver();

	@Test
	public void random() throws AWTException, InterruptedException {
		
		Robot robot = new Robot();
		 System.out.println("About to zoom in");
		 for (int i = 0; i < 3; i++) { 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_ADD);
		 robot.keyRelease(KeyEvent.VK_ADD);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 }
		 Thread.sleep(5000);
		 System.out.println("About to zoom out");
		 for (int i = 0; i < 4; i++) {
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 }
		 
driver.get("https://facebook.com");
driver.navigate().back();
// ((JavascriptExecutor) driver).executeScript("window.open()");
driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
Thread.sleep(5000);
driver.quit();

}

}
