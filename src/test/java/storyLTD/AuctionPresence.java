package storyLTD;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.base;
import resources.lotSize;
import resources.screenShotClass;
import storyLTD.pageObjects.HomePage;

import java.io.File;
import java.io.IOException;
//import org.testng.AssertJUnit;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuctionPresence extends base {
	WebDriver driver = initializeDriver();

	@Test
	public void Login() throws IOException, InterruptedException {

		driver.findElement(By.cssSelector("a.cb-enable")).click();
		
		HomePage home = new HomePage(driver);
		home.clickAuctionLink();
	

		String auctionPage = driver.findElement(By.xpath("//h2[@class='text-uppercase']")).getText();
		AssertJUnit.assertEquals(auctionPage, "ALL AUCTIONS");
		Assert.assertEquals(auctionPage, "ALL AUCTIONS");

		WebElement currentAuctionTitle = driver
				.findElement(By.xpath("(//div[@class='auction-items-details']/a/h1)[1]"));
		String currentAuctionTitleText = currentAuctionTitle.getText().toUpperCase();
		String currentAuctionDate = driver.findElement(By.xpath("(//div[@class='auction-items-details']/h2)[1]"))
				.getText();
		System.out.println("Current Auction : " + currentAuctionTitle.getText());
		System.out.println("Current Auction Date : " + currentAuctionDate);

		if (auctionCheck()) {
			System.out.print("Displayed\n");
			currentAuctionTitle.click();
			driver.findElement(By.xpath("//*[@id='carousel-example-generic']/a[1]")).click();
			String auctionPageTitle = driver
					.findElement(By.xpath("//h1[@id='ContentPlaceHolder1_auctionheader_event_title']")).getText();
			AssertJUnit.assertTrue("Title is Same", auctionPageTitle.contains(currentAuctionTitleText));
			Assert.assertTrue(auctionPageTitle.contains(currentAuctionTitleText), "Title is Same");
			new lotSize(driver);
		} else {
			System.out.print("Not Displayed\n");
			driver.findElement(By.xpath("(//a[@class='subscribe'])[1]")).click();
			String email = "mayur@saffronart.com";
			driver.findElement(By.cssSelector("input#footer_subscriber_email")).sendKeys(email);
			driver.findElement(By.cssSelector("input#footer_subscribe_submit")).click();
			System.out.println(driver.findElement(By.cssSelector("div.form-group p b")).getText());
		}

//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File(path + "\\MAutomation\\src\\main\\java\\screenShots\\screeshot.png"));
		new screenShotClass();
	}

	public boolean auctionCheck() {
		List<WebElement> viewCatalogueButton = driver
				.findElements(By.xpath("//div[@class='auction-items-details']/button"));

		boolean condition = viewCatalogueButton.size() > 0 && viewCatalogueButton.get(0).isDisplayed();

		return condition;
	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
