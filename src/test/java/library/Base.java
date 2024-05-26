package library;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {

	public ExtentReports extent;
	protected static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();

	public String pathSS = new File("").getAbsolutePath() + "\\Screenshots\\";
	public String pathReport = new File("").getAbsolutePath() + "\\Reports\\";

	@BeforeTest
	public void startReport() {
		ExtentSparkReporter sparkReporter;
		sparkReporter = new ExtentSparkReporter(pathReport + "testReport.html");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		sparkReporter.config().setDocumentTitle("Simple Automation Report");
		sparkReporter.config().setReportName("Test Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	@BeforeMethod
	public void Setup(Method method) {
		WebDriver driver = BrowserManager.doBrowserSetup(ReadProperties.getConfig("browserName"));

		DriverManager.set(driver);

		System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());
		threadLocalTest.set(extent.createTest(method.getName()));
	}

	public static WebDriver getDriver() {
		return DriverManager.get();
	}
	
	public static WebDriverWait getExplicitWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(Integer.parseInt(ReadProperties.getConfig("explicitWait"))));
	}
	
	public static Actions getAction() {
		return new Actions(getDriver());
	}

	public static ExtentTest extentTest() {
		return threadLocalTest.get();
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest().fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest().pass(result.getTestName());
		} else {
			extentTest().skip(result.getTestName());
		}
		getDriver().quit();
		extent.removeTest(extentTest());
	}

	@AfterTest
	public void tearDown() {
		System.out.println("After Test Thread ID: " + Thread.currentThread().getId());
		DriverManager.remove();
		extent.flush();
	}

}
