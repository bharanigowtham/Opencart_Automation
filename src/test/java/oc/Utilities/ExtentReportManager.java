package oc.Utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import oc.Testcases.Baseclass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String reportname;
	
	public void onStart(ITestContext testcontext) {
		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//		Date dt = new Date();
//		String currentDateTimeformat = df.format(dt);
		
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportname = "Test Automation Report " + timestamp + ".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+reportname);
		sparkReporter.config().setDocumentTitle("My Opencart Automation Report");
		sparkReporter.config().setReportName("Opencart test automation");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Lenovo Ideapad Slim 3", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("QA name", "Bharani Gowtham K");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		
		String os = testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("OS", os);
		
		String browsername = testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browsername);
		
		List<String> includedgroups =  testcontext.getCurrentXmlTest().getIncludedGroups();
		if(!includedgroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedgroups.toString());
		}
		
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + " Passed successfully...");
		
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " is failed....");
		test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imgpath = new Baseclass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void OnTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " is Skipped....");
		test.log(Status.INFO, result.getThrowable().getMessage());

		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
		String pathofextentreport = System.getProperty("user.dir") + ".\\reports\\"+ reportname;
		
		File extentReport = new File(pathofextentreport);
		
		try {
			
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
