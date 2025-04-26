package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DragAndDropSliderTest extends Base {

    @Test(dataProvider = "browsers", dataProviderClass = DataProvider.class)
    public void testDragAndDropSlider() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground");  // [cite: 6]
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();  // [cite: 6]

        WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));  // Locator: XPath
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 212, 0).perform();  //  Adjust offset to reach 95 (this will likely need fine-tuning)

        Thread.sleep(2000);
        WebElement rangeValue = driver.findElement(By.cssSelector("#rangeSuccess")); // Locator: CSS Selector
        Assert.assertEquals(rangeValue.getText(), "95", "Slider value is not 95");  // [cite: 7]
    }
}