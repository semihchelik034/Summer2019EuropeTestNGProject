package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {

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
    public  void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\semih\\Desktop\\test.txt");

        driver.findElement(By.id("file-submit")).click();

        //Verifying that uploaded file name is displayed
        String expectedFileName = "test.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expectedFileName,"Verifying that uploaded file name is expected file name");


    }

    @Test
    public  void test2(){
        driver.get("http://practice.cybertekschool.com/upload");

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";

        String filePath = projectPath + "/" + relativePath;

        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        //Verifying that uploaded file name is displayed
        String expectedFileName = "testfile.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expectedFileName,"Verifying that uploaded file name is expected file name");


    }
}
