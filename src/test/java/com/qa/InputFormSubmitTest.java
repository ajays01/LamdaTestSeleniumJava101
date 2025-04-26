package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InputFormSubmitTest extends Base {

    @Test(dataProvider = "browsers", dataProviderClass = DataProvider.class)
    public void testInputFormSubmit() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground");  // [cite: 7]
        driver.findElement(By.linkText("Input Form Submit")).click();  // [cite: 7]

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Submit']")).click();  // [cite: 8] Locator: TagName
        //WebElement errorElement = driver.findElement(By.className("error-message"));
        //Assert.assertEquals(errorElement.getText(), "Please fill out this field.", "Error message is incorrect");  // [cite: 8]

        driver.findElement(By.id("name")).sendKeys("ABCD XYZW");  // [cite: 9]
            driver.findElement(By.id("inputEmail4")).sendKeys("abcd.xyzw@qwerty.com");  // [cite: 9]
        driver.findElement(By.id("inputPassword4")).sendKeys("password@12345");  //  Add password field
        driver.findElement(By.id("company")).sendKeys("Acme Corp");  // Add company field
        driver.findElement(By.id("websitename")).sendKeys("www.acmecorp.com");  // Add website field

        Select countryDropdown = new Select(driver.findElement(By.name("country")));  // [cite: 9]
        countryDropdown.selectByVisibleText("United States");  // [cite: 9]

        driver.findElement(By.id("inputCity")).sendKeys("New York");  // Add city field
        driver.findElement(By.id("inputAddress1")).sendKeys("123 Main St");  // Add address1 field
        driver.findElement(By.id("inputAddress2")).sendKeys("Apt 4B");  // Add address2 field
        driver.findElement(By.id("inputState")).sendKeys("CA");  // Add state field
        driver.findElement(By.id("inputZip")).sendKeys("90210");  // Add zip code field

        driver.findElement(By.xpath("//button[text()='Submit']")).click();  // [cite: 10]

        Thread.sleep(2000);
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div/p"));
        Assert.assertTrue(successMessage.getText().contains("Thanks for contacting us, we will get back to you shortly."), "Success message is incorrect");  // [cite: 10, 11]
    }
}