package qe.core.ui.common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import qe.core.ui.driver.DriverHandler;

public class TestBase {

    DriverHandler driverHandler = new DriverHandler();

    @BeforeMethod
    public void setup() {
        driverHandler.initialize();
    }

    @AfterMethod
    public void tearDown() {
        driverHandler.tearDown();
    }

    @AfterClass
    void terminate() {
        driverHandler.terminate();
    }
}