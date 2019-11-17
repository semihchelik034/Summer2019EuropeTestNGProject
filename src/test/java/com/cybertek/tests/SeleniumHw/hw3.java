package com.cybertek.tests.SeleniumHw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hw3 {

    public static void main(String[] args) {

        //create browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to wikipedia
        driver.get("http://wikipedia.org/");

        //search box element
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"searchInput\"]"));

        //fill box element
        String value = "selenium webdriver";
        searchBox.sendKeys(value);

        //search button element
        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"pure-button pure-button-primary-progressive\"]"));

        //clicking search button
        searchButton.click();

        //"selenium (software)" a-element
        WebElement seleniumSoftware = driver.findElement(By.xpath("//a[@title=\"Selenium (software)\"]"));

        //clicking a-element
        seleniumSoftware.click();

        //url string array
        String[] url = driver.getCurrentUrl().split("/");

        //expected url ends
        String expectedUrlEnds = "Selenium_(software)";

        //actual url ends
        String actualUrlEnds = url[url.length-1];

        //verify url ends with "Selenium_(software)"
        if(actualUrlEnds.equals(expectedUrlEnds)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrlEnds = " + actualUrlEnds);
            System.out.println("expectedUrlEnds = " + expectedUrlEnds);
        }

        //qut browser
        //driver.quit();
    }
}
