package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {

    WebDriver driver = WebDriverFactory.getDriver("chrome");


    @BeforeMethod
    public void beforeMethod() {

        driver.manage().window().maximize();
    }

    @Test
    public void radioButton() {


        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        System.out.println("Is blue selected: " + blueRadioButton.isSelected());
        System.out.println("Is red selected: " + redRadioButton.isSelected());
        //Verify that blue radio button is selected
        Assert.assertTrue(blueRadioButton.isSelected(), "Verify that blue button is selected");
        //Verify that red radio button is not selected
        Assert.assertFalse(redRadioButton.isSelected(), "Verify that red button is not selected");

        redRadioButton.click();

        System.out.println("Is blue selected: " + blueRadioButton.isSelected());
        System.out.println("Is red selected: " + redRadioButton.isSelected());

        //verify that blue is not selected
        Assert.assertFalse(blueRadioButton.isSelected(), "Verify that blue button is not selected");
        //Verify that red button is selected
        Assert.assertTrue(redRadioButton.isSelected(), "Verify that red button is selected");

        driver.quit();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
