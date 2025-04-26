package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public void setup(String browser, String version, String platform) throws MalformedURLException {

        //  Set desired capabilities for LambdaTest
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);
        caps.setCapability("browserVersion", version);
        caps.setCapability("platformName", platform);
        caps.setCapability("se:recordVideo", true);
        caps.setCapability("se:recordNetwork", true);
        caps.setCapability("se:recordConsole", true);
        caps.setCapability("screenResolution", "1920x1080");
        caps.setCapability("name", "Selenium Java 101 Tests");  // Give your test a meaningful name

        String username = System.getenv("LT_USERNAME"); // Fetch from environment variables
        String accessKey = System.getenv("LT_ACCESS_KEY"); // Fetch from environment variables
        String gridUrl = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        driver = new RemoteWebDriver(new URL(gridUrl), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait 20 seconds [cite: 16]
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}