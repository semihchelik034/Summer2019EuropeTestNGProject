package com.cybertek.tests.Vytrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = new WebDriverFactory().getDriver("chrome");

        //open url
        driver.get("https://qa1.vytrack.com/user/login");

        //credentials
        String truckDriver = "user27sfsfs";
        String truckDriverPassword = "UserUser123";

        //locating login form
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));

        //fill login form
        username.sendKeys(truckDriver);
        password.sendKeys(truckDriverPassword);

        //clicking "Log in" button
        loginButton.click();

        //expected result
        String expectedResult = "https://qa1.vytrack.com/";

        //actual result
        String actualResult = driver.getCurrentUrl();

        if(actualResult.equals(expectedResult)){
            System.out.println("Positive test case: Pass");
        }

        //error message
        else {
            WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Invalid user name or password.')]"));
            if(errorMessage.getText().equals("Invalid user name or password.")){
                System.out.println("Negative test case: Pass");
            }
        }

        //close browser
        driver.quit();
    }
}
