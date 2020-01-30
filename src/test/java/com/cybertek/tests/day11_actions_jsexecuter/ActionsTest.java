package com.cybertek.tests.day11_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverTest(){
        driver.get("http://practice.cybertekschool.com/hovers");


    }

    @Test
    public void DragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();

    //        actions.dragAndDrop(source,target).perform();

        String expectedText = "You did great!";
        Assert.assertEquals(target.getText(),expectedText,"It should display expected text");

    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> images = driver.findElements(By.tagName("img"));

        Actions actions = new Actions(driver);

        int cnt = 1;

        for (WebElement img : images) {

            actions.moveToElement(img).perform();

            WebElement text = driver.findElement(By.xpath("//h5[.='name: user" + cnt + "']"));

            Assert.assertTrue(text.isDisplayed());

            cnt++;
        }

    }
}
