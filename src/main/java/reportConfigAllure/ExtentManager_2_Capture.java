package reportConfigAllure;


import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager_2_Capture {

	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			String workingDir = System.getProperty("user.dir");
			extent = new ExtentReports(workingDir + "\\ExtentReportsV2\\ExtentReportResults.html", true);
		}
		return extent;
	}
}
