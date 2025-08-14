package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject(){
        //ExtentReport // ExtentSparkReporter
        String path = "C:\\Seleniumm\\SeleniumFrameworkDesign2\\reports\\index.html";
        //C:\Seleniumm\ExtentReports
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Mesut Said Öztürk");

        return extent;
    }
}
