package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.net.MalformedURLException;
import java.net.URL;
import com.qa.CapabilitiesGenerator;

public class Base {
    protected WebDriver driver;
    protected String username = "ajaysonawane10outlookcom";
    protected String accessKey = "LT_N4GxkwLXBrkZFzeytoscKgwi1e9yZMwwsQNBcZ5R9EMnNi1";

    @BeforeMethod(alwaysRun = true)
    public void setUp(Object[] data) throws MalformedURLException {
        String browser = (String) data[0];
        String version = (String) data[1];
        String platform = (String) data[2];

        DesiredCapabilities capabilities = CapabilitiesGenerator.getCapabilities(browser, version, platform, username, accessKey);
        driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), capabilities);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
