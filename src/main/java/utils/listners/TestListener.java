package utils.listners;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import qe.core.ui.driver.DriverHandler;
import rp.com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class TestListener extends ReportPortalTestNGListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);
    private static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\screenshots\\";

    DriverHandler driverHandler = new DriverHandler();

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenShotOfFailure(result);
        File file = new File(FILE_PATH + getTestMethodName(result) + ".jpg");
        Files.asByteSink(file);

        LOGGER.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath(), "Failure Screenshot :");
        super.onTestFailure(result);
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void takeScreenShotOfFailure(ITestResult result) {
        String methodName = result.getMethod().getConstructorOrMethod().getName();

        TakesScreenshot scrShot = ((TakesScreenshot) driverHandler.getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(FILE_PATH + methodName + ".jpg");
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File creation success");

    }
}