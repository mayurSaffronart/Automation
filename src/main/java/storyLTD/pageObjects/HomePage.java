package storyLTD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By homePagePopUpClose = By.cssSelector("#ucnavigationnew_close > img");
	By homePageLoginLink = By.linkText("Login/Signup");
	By homePageShopLink = By.xpath("//a[text()='Shop']");
	By homePageAuctionLink = By.xpath("//a[text()='Auction']");
	By homePageStoryPrintsLink = By.xpath("//a[text()='StoryLtd Prints ']");

	@FindBy(id = "ucnavigationnew_auth_control_username_input")
	WebElement loginId;

	@FindBy(id = "ucnavigationnew_auth_control_password_input")
	WebElement password;

	@FindBy(id = "ucnavigationnew_auth_control_login_button")
	WebElement signIn;

	@FindBy(css = "span[id='ucnavigationnew_LoginView2_LoginName1']")
	WebElement loggedinId;

	@FindBy(xpath = "//a[contains(@text(),'Reset Your password']")
	WebElement resetPassLink;

	@FindBy(css = "#ucnavigationnew_subscriber_email")
	WebElement subscribeEmail;

	@FindBy(css = "#ucnavigationnew_subscribe_button")
	WebElement subscribeSignUp;

	@FindBy(id = "ucnavigationnew_LoginView2_LoginStatus1")
	WebElement logoutLink;

	public void enterLoginId(String id) {
		loginId.sendKeys(id);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickSignIn() {
		signIn.click();
	}

	public WebElement loggedinId() {
		return loggedinId;
	}

	public WebElement subscriberPopUpEnterText() {
		return subscribeEmail;
	}

	public void subscriberPopUpSignUp() {
		subscribeSignUp.click();
	}

	public void clickHomePageLoginLink() {
		driver.findElement(homePageLoginLink).click();
	}

	public void clickHomePageShopLink() {
		driver.findElement(homePageShopLink).click();
	}

	public void clickHomePageAuctionLink() {
		driver.findElement(homePageAuctionLink).click();
	}

	public void clickHomePageStoryPrintsLink() {
		driver.findElement(homePageStoryPrintsLink).click();
	}

	public void clickHomePagePopUpClose() {
		driver.findElement(homePagePopUpClose).click();
	}

	public void logOut() {
		logoutLink.click();
	}

}
