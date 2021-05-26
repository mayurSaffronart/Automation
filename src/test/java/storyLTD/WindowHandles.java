package storyLTD;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.base;

public class WindowHandles extends base {
	WebDriver driver = initializeDriver();

	@Test
	public void WindowHandle() {

		driver.findElement(By.xpath("//img[@title='Pinterest']")).click();

		Set<String> windows = driver.getWindowHandles();

		System.out.println(windows);

		Iterator<String> it = windows.iterator();

		String parentID = it.next();
		String childID = it.next();

		driver.switchTo().window(childID);

		System.out.println(driver.getTitle());

		driver.switchTo().window(parentID);

	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}
