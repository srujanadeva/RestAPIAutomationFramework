package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Setup implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public static String name ="deva";

    public void onStart(ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "/reports/" + fileName;
        extentReports = ExtentReportManager.createInstance(fullReportPath, "Test API Automation Report", "Test Execution Report");
    }

    public void onFinish(ITestContext context) {
        if(extentReports != null)
            extentReports.flush();
    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest("Test Name - " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
        extentTest.set(test);
    }

}
