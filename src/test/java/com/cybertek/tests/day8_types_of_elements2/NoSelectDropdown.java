package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownELement = driver.findElement(By.id("dropdownMenuLink"));

        dropdownELement.click();
        List<WebElement> listofLinks = driver.findElements(By.className("dropdown-item"));

        Assert.assertEquals(listofLinks.size(),5,"Verify that number of links is 5");

        for (WebElement listofLink : listofLinks) {

            System.out.println(listofLink.getText());

        }

        //locate the element and click it
        // driver.findElement(By.linkText("Yahoo")).click();

        listofLinks.get(3).click();


    }
}
