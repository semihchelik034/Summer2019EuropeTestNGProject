package com.cybertek.tests.SeleniumHw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class hw2 {

    public static void main(String[] args) {

        //create browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to amazon
        driver.get("https://www.amazon.co.uk/");

        //navigate to ebay
        driver.navigate().to("https://www.ebay.co.uk/");

        //search box element
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));

        //value for search box
        String value = "selenium";

        //fill search box element
        searchBox.sendKeys(value);

        //search button element
        WebElement searchButton = driver.findElement(By.xpath("//input[@id=\"gh-btn\"]"));

        //clicking search button
        searchButton.click();

        //title string
        String titleString = driver.getTitle().split(" ")[0];


        if(titleString.equals(value)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("value = " + value);
            System.out.println("titleString = " + titleString);
        }

      //quit browser
       driver.quit();
    }
}
