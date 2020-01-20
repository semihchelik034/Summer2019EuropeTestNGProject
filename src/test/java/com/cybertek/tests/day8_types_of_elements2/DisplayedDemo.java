package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");




        //locating start button
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));

        //creating webelement for userInput
        WebElement usernameInput = driver.findElement(By.id("username"));

        //verify that username input box is not displayed
        Assert.assertFalse(usernameInput.isDisplayed());

        //clicking start button
        startButton.click();

        //wait for 3 seconds
        Thread.sleep(5000);


        //Verifying username exist
        Assert.assertTrue(usernameInput.isDisplayed(),"Verifying usernameInput is displayed");


        //final product
        usernameInput.sendKeys("Yessir! i located it...");




    }
}
