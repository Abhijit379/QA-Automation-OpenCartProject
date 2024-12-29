package utilities;

import java.awt.Desktop;
import java.io.File;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.net.URI;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtendReportandListners implements ITestListener{

	public ExtentSparkReporter report;
	public ExtentReports extent;
	public ExtentTest test;
	
	String name;
	public void onStart(ITestContext tex)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.DD").format(new Date(27));
		name = "TestCaseReport.html";
		report = new ExtentSparkReporter(".\\reports\\"+name);
		report.config().setDocumentTitle("Automation report");
		report.config().setReportName("Testing");
		report.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Username ", System.getProperty("user.name"));
		String test = tex.getCurrentXmlTest().getParameter("os");
		
		List<String> grp = tex.getCurrentXmlTest().getIncludedGroups();
		if (!grp.isEmpty()) {
			extent.setSystemInfo("Groups", grp.toString());
		}
		
	}
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.PASS, result.getName()+" Successfully Executed");
		
	}
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+" Failed");
		try {
			String img = new BaseClass().capturescreen(result.getName());
			test.addScreenCaptureFromPath(img);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void onFinish(ITestContext context){
		extent.flush();
		String path = System.getProperty("user.dir")+"\\reports\\"+name;
		File file = new File(path);
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		try {
			String path1 ="file:///"+System.getProperty("user.dir")+"\\reports\\"+name;
			
			URI linkuri= new URI(path1);
			URL linkurl=linkuri.toURL();
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(linkurl));
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthentication("", "");
			email.setSSL(true);
			email.setFrom("abhijitbarkul379@gmail.com");
			email.setSubject("Test Report");
			email.setMsg("");
			email.addTo("20210812031@dypiu.ac.in");
			email.attach(linkurl,"Attached file","PFA");
			email.send();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		*/
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}
