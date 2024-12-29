package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties properties;
	@Parameters({"os","browser"})
	@BeforeClass(groups = {"Master","Regression","Sanity"})
	
	public void setup(String os,String br) throws IOException {
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		properties = new Properties();
		properties.load(file);
		if (properties.getProperty("env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if (os.equalsIgnoreCase("window")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else if (os.equalsIgnoreCase("macos")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matched os");
			}
			
		}
		switch (br) {
		case "Chrome": driver = new ChromeDriver();
			break;
			case "Edge": driver = new EdgeDriver();
			break;
			case "Firefox": driver = new FirefoxDriver();
			break;
		default:
			return;
		}
//		driver = new ChromeDriver();
		logger = LogManager.getLogger(this.getClass());
		
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}
	public String randamString() {
		String xString= RandomStringUtils.randomAlphabetic(5);
		return xString;
	}
	public String randomint() {
		String i= RandomStringUtils.randomNumeric(10);
		return i;
	}
	public String afphanum() {
		String pas = RandomStringUtils.randomAlphanumeric(9);
		return pas;
	}
	@AfterClass(groups = {"Master","Regression","Sanity"})
	public void exit() throws InterruptedException {
//		Thread.sleep(5000);
		driver.quit();
	}
	
	public String capturescreen(String name) {
		String timestamp = new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date(0));
		TakesScreenshot screen = (TakesScreenshot) driver;
		File sourcFile = screen.getScreenshotAs(OutputType.FILE);
		String targetfilepath = System.getProperty("user.dir")+("\\screenshot" + name + "_" + timestamp);
		File targetFile = new File(targetfilepath);
		sourcFile.renameTo(targetFile);
		return targetfilepath;
	}
}
