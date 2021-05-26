package resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class lotSize {
	WebDriver driver;

	
	public lotSize(WebDriver driver) throws InterruptedException {

		this.driver=driver;

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		long iHeight = (long) (js.executeScript("return document.body.scrollHeight"));

		while (true) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			long cHeight = (long) (js.executeScript("return document.body.scrollHeight"));
			if (iHeight == cHeight) {
				break;
			}
			iHeight = cHeight;
		}

		List<WebElement> listOfLots = driver.findElements(By.cssSelector("ul#dynamicProductsList li"));

		int count = listOfLots.size();
		
		System.out.println("Lot Size : " + count);

		js.executeScript("alert('Lot Size : " + count + "')");

	}
}
