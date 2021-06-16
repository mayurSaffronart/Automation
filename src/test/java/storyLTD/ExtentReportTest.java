package storyLTD;

import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTest {

	@BeforeClass
	public static ExtentReports setExtentReports()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index";
		ExtentSparkReporter rep = new ExtentSparkReporter(path);
		rep.config().setReportName("Test Report");
		rep.config().setDocumentTitle("This is a test report");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester", "Mayur");
		return extent;
	}
}
