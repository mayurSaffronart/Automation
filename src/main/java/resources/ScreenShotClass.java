package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShotClass {
	
	public void screenShot(WebDriver driver, String path) throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path1=path;
		FileUtils.copyFile(src, new File(path1 + "\\MAutomation\\src\\main\\java\\screenShots\\screeshot.png"));
	}

}
