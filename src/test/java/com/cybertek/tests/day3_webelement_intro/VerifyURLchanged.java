package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VerifyURLchanged {
    /**
     *
     Verify URL changed
     open browser
     go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     enter any email
     click on Retrieve password
     verify that url changed to http://practice.cybertekschool.com/email_sent

     */

    public static void main(String[] args) {

        //open the chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        Faker faker = new Faker();

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInput = driver.findElement(By.name("email"));

        //sendKeys() --> send keyboard actions to webelement / enters given text
        String randomEmail = faker.firstName().toLowerCase() + "_" + faker.lastName().toLowerCase() + "@gmail.com";
        emailInput.sendKeys(randomEmail);

        //locate to password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        //click the button
        retrievePasswordButton.click();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }

        //close
        driver.quit();
    }
}
