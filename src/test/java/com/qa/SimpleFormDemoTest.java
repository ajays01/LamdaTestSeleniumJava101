package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleFormDemoTest extends Base {

    @Test(dataProvider = "browsers", dataProviderClass = DataProvider.class)
    public void testSimpleFormDemo() {
        driver.get("https://www.lambdatest.com/selenium-playground");  // [cite: 1]
        driver.findElement(By.linkText("Simple Form Demo")).click();  // [cite: 2]  Locator: LinkText
        Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");  // [cite: 3]

        String message = "Welcome to Lambda Test";  // [cite: 4]
        WebElement inputField = driver.findElement(By.id("user-message"));  // Locator: ID
        inputField.sendKeys(message);  // [cite: 5]

        driver.findElement(By.id("showInput")).click();  // [cite: 6] Locator: ID

        WebElement displayedMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(displayedMessage.getText(), message, "Displayed message is incorrect");  // [cite: 7]
    }
}