package com.qa;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesGenerator {
    public static DesiredCapabilities getCapabilities(String browser, String version, String platform, String username, String accessKey) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", version);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("user", username);
        capabilities.setCapability("accessKey", accessKey);
        capabilities.setCapability("build", "Selenium Java 101 Build");
        capabilities.setCapability("name", "LambdaTest Assignment");
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("console", true);
        return capabilities;
    }
}