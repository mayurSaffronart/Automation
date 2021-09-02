package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotClass {
	WebDriver driver;
	
	public void takeScreenShot(WebDriver driver, String methodName) throws IOException
	{
		this.driver=driver;
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(path + "\\src\\main\\java\\screenShots\\"+methodName+".png"));
		
	}
	
}
