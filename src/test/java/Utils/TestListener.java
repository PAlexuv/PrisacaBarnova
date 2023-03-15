package Utils;

import PrisacaBarnova.PageObjects.BasePoPagePB;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BasePoPagePB implements ITestListener {
    private static ExtentReports extentReports = new ExtentReports();
    private static ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");//in path we use the name of the file we want to create

    @Override
    public void onTestFailure(ITestResult result) {

        //********** Failed Test Screenshot ***************
        String failedTest = result.getName();
        log.error("Test '" + failedTest + "' has failed.. take screenshot");
        takeScreenshotNamed(failedTest);
        //**************************

        //-------------- EXTENT REPORTS -----------------
        //Attach the reporter to Extent Report where we attch the reporter that we created up from ExtentSparkReporter : reporter
        extentReports.attachReporter(reporter);
        //Add the failed test and a log entry to our report  - from up String failedTest - name of the test that failed;
        //.log is an overloaded method that allows us to write different things to the report -stackTrace, a screenshot, or just a Message
        extentReports.createTest(failedTest)
                .log(Status.FAIL, "test failure");
        //last step: finalize the report
        extentReports.flush();
        //-----------------------------------------------

    }
}

//Old code for failed test screenshot, delete or uncomment:
//TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File file = screenshot.getScreenshotAs(OutputType.FILE);
//
//        LocalDateTime currentTime = LocalDateTime.now();
//        String dateTimeFormat = currentTime.format(dateTimeFormatter).split("\\.")[0].replaceAll(":", "");
//
//        String testName = result.getMethod().getMethodName();
//        String screenshotName = SCREENSHOT_PATH + "\\screenshot-" + testName + "-" + dateTimeFormat + ".jpeg";
//
//        File savedScreenshot = new File(screenshotName);
//
//        try {
//            FileUtils.copyFile(file, savedScreenshot);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        log.info("Take screenshot... :" + testName);