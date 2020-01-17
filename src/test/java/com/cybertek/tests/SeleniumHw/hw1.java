package com.cybertek.tests.SeleniumHw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class hw1 {

    public static void main(String[] args) {

        //create browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to ebay
        driver.get("https://www.ebay.co.uk/");

        //search box element
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));

        //fill search box element
        searchBox.sendKeys("selenium");

        //search button element
        WebElement searchButton = driver.findElement(By.xpath("//input[@id=\"gh-btn\"]"));

        //clicking search button
        searchButton.click();

        //results element
        WebElement results = driver.findElement(By.xpath("//h1[@class=\"srp-controls__count-heading\"]/*[1]"));

        //printing number of results
        String resultsString = results.getText();

        //printing number of results
        System.out.println("resultsNumber = " + resultsString);

        //quit browser
        driver.quit();
    }
}
