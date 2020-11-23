package reportConfig;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager4 {
	private static ExtentReports extent;

	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentSparkReporter  sparkReporter = new ExtentSparkReporter(path);
		sparkReporter = new ExtentSparkReporter("./reports/extent.html");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setDocumentTitle("Automation Reports");
		sparkReporter.config().setReportName("Automation Test Results");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Code Test");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(sparkReporter);
		return extent;
	}

	public static String getReportName() {
		Date d = new Date();
		String fileName = "AutomationReport_" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}
}
