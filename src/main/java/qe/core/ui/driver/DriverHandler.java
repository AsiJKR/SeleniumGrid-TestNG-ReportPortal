package qe.core.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverHandler {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    protected WebDriver webDriver = null;

    protected static String host = "grid url";
    protected static String testEnvironment = System.getProperty("environment", "QA");

    public DriverHandler() {
        if (driver == null) {
            initialize();
        }
    }

    public void initialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--enable-automation");
        options.addArguments("--incognito");

        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Nexus 5");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        if (host.equalsIgnoreCase("localhost")) {
            webDriver = new ChromeDriver(options);
        } else {
            try {
                driver.set(new RemoteWebDriver(new URL(host), capability));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void tearDown() {
        getDriver().quit();
    }

    public void terminate() {
        driver.remove();
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
