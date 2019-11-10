package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.amazon.co.uk/");

        WebElement searchElement = driver.findElement(By.xpath("//*[@value=\"Go\"]"));

        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));


        searchBox.sendKeys("selenium");

        searchElement.click();

    }
}
