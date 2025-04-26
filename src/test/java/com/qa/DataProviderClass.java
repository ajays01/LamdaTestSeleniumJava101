package com.qa;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "browserProvider")
    public static Object[][] browserProvider() {
        return new Object[][]{
                {"Windows 10", "Chrome", "120.0"},
                {"macOS Ventura", "Edge", "127.0"},
                {"Windows 11", "Firefox", "130.0"},
                {"Windows 10", "Internet Explorer", "11.0"}
        };
    }
}