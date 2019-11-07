package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagnameTest {

    public static void main(String[] args) {

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //navigate to website
        driver.get("http://practice.cybertekschool.com/sign_up");
        //enter full name
        WebElement fullnameInput = driver.findElement(By.tagName("input"));
        fullnameInput.sendKeys("Mike Smith With TagName");
        //enter email
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike@gmail.com");
        WebElement signUpButton = driver.findElement(By.tagName("button"));
        signUpButton.click();

        String message = driver.findElement(By.tagName("h3")).getText();
        System.out.println(message);

        //print the message using tagname locator
    }
}
