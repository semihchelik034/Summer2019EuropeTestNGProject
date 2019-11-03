package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLnotchanged {

    /**
     *     Verify URL not changed
     *     open browser
     *     go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     *     click on Retrieve password
     *     verify that url did not change
      */

    public static void main(String[] args) {

        //open chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //click on Retrieve password
        //WebElement --> class that represents elements on the webpage
        //findElement --> method used to find element on a page
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));

        //save url to string variable
        String expectedUrl = driver.getCurrentUrl();

        //click() --> clicking web element
        retrievePassword.click();

        //actual Url
        String actualUrl = driver.getCurrentUrl();

        //verify that url is not changed
        if(expectedUrl.equals(actualUrl)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close the browser
        driver.quit();
    }
}
