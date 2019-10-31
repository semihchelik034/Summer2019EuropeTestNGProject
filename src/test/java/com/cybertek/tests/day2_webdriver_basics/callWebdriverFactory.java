package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.webDriverFactory;
import org.openqa.selenium.WebDriver;

public class callWebdriverFactory {
    public static void main(String[] args) {

        WebDriver driver = webDriverFactory.getDriver("chrome");

        driver.get("https://google.com");
    }
}
