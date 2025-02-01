package oc.Testcases;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Baseclass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity", "Regression", "Master", "Datadriven"})
	@Parameters({"os", "browser"})
	public void setup(String os, String browser) throws InterruptedException, Exception {
		FileReader filereader = new FileReader(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(filereader);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(prop.getProperty("execution_environment").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//Windows selection
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("NO MATCHING OPERATING SYSTEMS FOUND....");
				return;
			}
			
			//Browser selection
			if(browser.equalsIgnoreCase("chrome"))
			{
				capabilities.setBrowserName("chrome");
			}
			else if(browser.equalsIgnoreCase("edge")) 
			{
				capabilities.setBrowserName("MicrosoftEdge");
			}
			else if(browser.equalsIgnoreCase("firefox")) 
			{
				capabilities.setBrowserName("firefox");
			}
			else {
				System.out.println("NO MATCHING BROWSER FOUND");
				return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
			
			System.out.println("*********** REMOTE RUN STARTED *********");
		}
		
		else if(prop.getProperty("execution_environment").equalsIgnoreCase("local")) {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}
			else {
				logger.error("Provide correct browser name ");
				System.out.println("Provide correct browser name....");
				return;
			}
			
			System.out.println("*********** LOCAL RUN STARTED *********");

		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appurl"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	
	@AfterClass(groups= {"Sanity", "Regression", "Master", "Datadriven"})
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	public String randomstring() {
		String genstring = RandomStringUtils.randomAlphabetic(5);
		return genstring;
	}
	
	public String randomnum() {
		String genstring = RandomStringUtils.randomNumeric(10);
		return genstring;
	}
	
	public String randomalphanum() {
		String genstring = RandomStringUtils.randomAlphanumeric(8);
		return genstring;
	}
	
	
	public String captureScreen(String tname) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetfilepath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timestamp + ".png";
		File targetfile = new File(targetfilepath);
		sourcefile.renameTo(targetfile);
		return targetfilepath;
		
		
	}
}
