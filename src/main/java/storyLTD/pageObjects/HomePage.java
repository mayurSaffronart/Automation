package storyLTD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By popUpClose = By.cssSelector("#ucnavigationnew_close > img");
	By loginlink = By.linkText("Login/Signup");
	By shopLink = By.xpath("//a[text()='Shop']");
	By auctionLink = By.xpath("//a[text()='Auction']");
	By storyPrintsLink = By.xpath("//a[text()='StoryLtd Prints ']");
	
	@FindBy(css= "#ucnavigationnew_subscriber_email")
	WebElement email;
	
	@FindBy(css="#ucnavigationnew_subscribe_button")
	WebElement signup;
	
	public void clickPopUpClose()
	{
		driver.findElement(popUpClose).click();
	}
	
	public WebElement enterText()
	{
		return email;
	}
	
	public void signUp()
	{
		signup.click();
	}
	
	public void clickLoginLink()
	{
		driver.findElement(loginlink).click();
	}

	public void clickShopLink()
	{
		driver.findElement(shopLink).click();
	}
	
	public void clickAuctionLink()
	{
		driver.findElement(auctionLink).click();
	}
	
	public void clickStoryPrintsLink()
	{
		driver.findElement(storyPrintsLink).click();
	}
	
	
}
