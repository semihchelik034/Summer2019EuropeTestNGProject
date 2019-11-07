package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput = driver.findElement(By.name("full_name"));
        fullnameInput.sendKeys("Mike Smith");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("MikeSmith@gmail.com");

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        String actualMessage = driver.findElement(By.name("signup_message")).getText();

        if(expectedMessage.equals(actualMessage)) System.out.println("PASS");
        else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        //close the browser
        driver.quit();
    }
}
