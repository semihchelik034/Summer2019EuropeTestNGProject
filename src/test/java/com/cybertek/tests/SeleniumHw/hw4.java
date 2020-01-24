package com.cybertek.tests.SeleniumHw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class hw4 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testCase1(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on registration form
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();

        //entering into date of birth input box
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("wrong_dob");

        //Verify that warning message is displayed
        Assert.assertTrue( driver.findElement(By.xpath("//*[text()='The date of birth is not valid']")).isDisplayed(),"Verifying that warning message is displayed");

    }

    @Test
    public void testCase2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on registration form
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();

        //List of checkbox elements
        List<WebElement> programmingLanguageOptions = driver.findElements(By.className("form-check-input"));

        //Verify that there is 3 options
        Assert.assertEquals(programmingLanguageOptions.size(),3,"Verify that there is 3 options");

        //Verify that all 3 options are displayed
        for (WebElement programmingLanguageOption : programmingLanguageOptions) {
            Assert.assertTrue(programmingLanguageOption.isDisplayed(),"Verify that options for programming languages are displayed");
        }
    }

    @Test
    public void testCase3(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on registration form
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();

        //entering only one alphabetic character into first name input box
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("S");

        //Verifying that warning message is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[.=\"first name must be more than 2 and less than 64 characters long\"]")).isDisplayed(),"Verifying that warning message is displayed");
    }

    @Test
    public void testCase4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on registration form
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();

        //entering only one alphabetic character into first name input box
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("C");

        //Verifying that warning message is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='The last name must be more than 2 and less than 64 characters long']")).isDisplayed(),"Verifying that warning message is displayed");

    }

    @Test
    public void testCase5(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on registration form
        driver.findElement(By.cssSelector("a[href='/registration_form']")).click();

        //entering valid first name
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Semih");

        //entering valid last name
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Chelik");

        //entering valid username
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("cheliksemih");

        //entering valid email address
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("semihchelik@gmail.com");

        //entering valid password
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("Semih1234");

        //entering valid phone number
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("1-123-123-1234");

        //selecting gender
        driver.findElement(By.cssSelector("[value='male']")).click();

        //entering valid date of birth
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("12/12/1912");

        //selecting department
        WebElement departmentDropdown = driver.findElement(By.cssSelector("[name='department']"));

        Select departmentList = new Select(departmentDropdown);

        departmentList.selectByValue("DE");

        //selecting job title
        WebElement jobTitleDropdown = driver.findElement(By.cssSelector("[name='job_title']"));

        Select jobTitleList = new Select(jobTitleDropdown);

        jobTitleList.selectByVisibleText("Developer");

        //selecting java as a programming language
        driver.findElement(By.cssSelector("[value='java']")).click();

        //clicking sign up button
        driver.findElement(By.id("wooden_spoon")).click();

        //Verifying that following success message is displayed
        String expectedSuccessMessage = "You've successfully completed registration!";

        Assert.assertEquals(driver.findElement(By.cssSelector("[role='alert']>p")).getText(),expectedSuccessMessage,"Verify that expected success message is displayed");

    }

    @Test
    public void testCase6(){
        driver.get("https://www.tempmailaddress.com/");

        //Copy and save email as a string
        String email = driver.findElement(By.xpath("//span[@id='email']")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        //entering valid name
        driver.findElement(By.cssSelector("input[name='full_name']")).sendKeys("John Wick");

        //entering email from the step 2
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);

        //clicking sign up button
        driver.findElement(By.cssSelector("button[name='wooden_spoon']")).click();

        //Verifying that following message is displayed
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Verifying expected message is displayed");

        //navigate back
        driver.navigate().to("https://www.tempmailaddress.com");

        //verifying that you've received an email
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        String actualEmail = driver.findElement(By.xpath("(//*[@class='odMobil'])[1]")).getText();
        Assert.assertEquals(actualEmail,expectedEmail,"Verify that email is from expected email");

        //clicking on that email to open it
        driver.findElement(By.xpath("(//*[@class='odMobil'])[1]")).click();

        //verifying that email is from expected email
        String expectedEmail2 = "do-not-reply@practice.cybertekschool.com";
        String actualEmail2 = driver.findElement(By.id("odesilatel")).getText();
        Assert.assertEquals(actualEmail2,expectedEmail2,"Verify that email is from expected email");

        //Verifying that subject is expected subject
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(actualSubject,expectedSubject,"Verifying that subject is expected subject");

    }

    @Test
    public void testCase7(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on file upload
        driver.findElement(By.linkText("File Upload")).click();

        //clicking on upload file and uploading .txt file
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\semih\\Desktop\\testCase7.txt");

        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //Verifying subject is "file uploaded"
        String expectedSubject = "File Uploaded!";
        String actualSubject = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualSubject,expectedSubject,"Verifying that actual subject is equal to expected subject");

        //Verifying that uploaded file name is displayed
        String expectedFileName = "testCase7.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expectedFileName,"Verifying that uploaded file name is expected file name");

    }

    public void testCase8(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on Autocomplete
        driver.findElement(By.linkText("Autocomplete")).click();

        //entering value into country input box
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        //Verifying expected message is displayed
        String expectedMessage = "You selected: United States of America";
        String actualMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that expected message is displayed");

    }

    @DataProvider(name="Testcase9-12_Data")
    public Object[][] getData(){

        Object[][] testData = new Object[4][1];

        testData[0][0] = "200";
        testData[1][0] = "301";
        testData[2][0] = "404";
        testData[3][0] = "500";

        return  testData;
    }

    @Test(dataProvider = "Testcase9-12_Data")
    public void testCase9(String number){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //click on status codes
        driver.findElement(By.linkText("Status Codes")).click();

        //clicking on 200
        driver.findElement(By.linkText(number)).click();

        //Verifying that expected message is displayed
        String expectedMessage = "This page returned a " + number + " status code";
        String actualMessage = driver.findElement(By.tagName("p")).getText();
        actualMessage = actualMessage.substring(actualMessage.indexOf("This"), actualMessage.indexOf("."));
        Assert.assertEquals(actualMessage,expectedMessage,"Verifying that expected message is displayed");

    }



}
