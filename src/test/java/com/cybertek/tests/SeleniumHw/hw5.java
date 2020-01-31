package com.cybertek.tests.SeleniumHw;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class hw5 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Login as store manager for every test case
        driver.get("https://qa1.vytrack.com/");

        String Username = "storemanager85";
        String Password = "UserUser123";

        WebElement usernameElement = driver.findElement(By.name("_username"));
        WebElement passwordElement = driver.findElement(By.name("_password"));

        usernameElement.sendKeys(Username);
        passwordElement.sendKeys(Password);

        WebElement rememberCheckbox = driver.findElement(By.className("custom-checkbox__text"));
        rememberCheckbox.click();

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testCase1(){

        Actions actions = new Actions(driver);

        WebElement ActivitiesElement = driver.findElement(By.linkText("Activities"));
        actions.moveToElement(ActivitiesElement).perform();
        WebElement CalendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        actions.moveToElement(CalendarEventsElement).click().build().perform();


        WebElement OptionsElement = driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']"));
        Assert.assertTrue(OptionsElement.isDisplayed(),"Verify that page subtitle 'Options' is displayed");
    }

    @Test
    public void testCase2(){

        Actions actions = new Actions(driver);

        WebElement ActivitiesElement = driver.findElement(By.linkText("Activities"));
        actions.moveToElement(ActivitiesElement).perform();
        WebElement CalendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        actions.moveToElement(CalendarEventsElement).click().build().perform();


        WebElement pageNumber = driver.findElement(By.className("input-widget"));
        Assert.assertEquals(pageNumber.getAttribute("value"),"1","Verify page number is 1");
    }

    @Test
    public void testCase3() throws InterruptedException {

        Actions actions = new Actions(driver);

        Thread.sleep(10000);
        WebElement ActivitiesElement = driver.findElement(By.linkText("Activities"));
        actions.moveToElement(ActivitiesElement).perform();
        WebElement CalendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        actions.moveToElement(CalendarEventsElement).click().build().perform();

        Thread.sleep(10000);
        WebElement viewPerPageNumber = driver.findElement(By.cssSelector("button[data-toggle='dropdown']"));
        Assert.assertEquals(viewPerPageNumber.getText(),"25","Verify that view per page number is equals to '25'");
    }

    @Test
    public void testCase4() throws InterruptedException {

        Actions actions = new Actions(driver);

        Thread.sleep(10000);
        WebElement ActivitiesElement = driver.findElement(By.linkText("Activities"));
        actions.moveToElement(ActivitiesElement).perform();
        WebElement CalendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        actions.moveToElement(CalendarEventsElement).click().build().perform();


        Thread.sleep(10000);
        WebElement numberOfRecords = driver.findElement(By.xpath("//*[@class='pagination pagination-centered']/label[3]"));
        String[] numberOfRecordsSplit = numberOfRecords.getText().split(" ");
        int numberofrecords = Integer.parseInt(numberOfRecordsSplit[2]);

        List<WebElement> tableRows = driver.findElements(By.cssSelector("[class='grid-row row-click-action']"));
        int numberOfTableRows = tableRows.size();

        Assert.assertEquals(numberofrecords,numberOfTableRows,"Verify that number of calendar events (rows in the table) is equals to number of records");
    }

    @Test
    public void testCase5() throws InterruptedException {

        Actions actions = new Actions(driver);

        Thread.sleep(10000);
        WebElement ActivitiesElement = driver.findElement(By.linkText("Activities"));
        actions.moveToElement(ActivitiesElement).perform();
        WebElement CalendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        actions.moveToElement(CalendarEventsElement).click().build().perform();


        Thread.sleep(10000);
        WebElement selectAllCheckbox = driver.findElement(By.cssSelector("[class='btn btn-default btn-small dropdown-toggle']>input"));
        selectAllCheckbox.click();

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[tabindex='-1'][type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }
    }


    @Test
    public void testCase6() throws InterruptedException {

        Actions actions = new Actions(driver);

        Thread.sleep(10000);
        WebElement ActivitiesElement = driver.findElement(By.linkText("Activities"));
        actions.moveToElement(ActivitiesElement).perform();
        WebElement CalendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        actions.moveToElement(CalendarEventsElement).click().build().perform();


        Thread.sleep(5000);
        WebElement testersMeeting = driver.findElement(By.xpath("//*[@class='grid-row row-click-action'][3]"));
        testersMeeting.click();

        Thread.sleep(5000);
        WebElement title = driver.findElement(By.xpath("(//*[.='Testers meeting'])[2]"));
        Assert.assertEquals(title.getText(),"Testers meeting","Verify that title is 'Testers Meeting'");

        WebElement description = driver.findElement(By.xpath("//*[.='This is a a weekly testers meeting ']"));
        Assert.assertEquals(description.getText(),"This is a a weekly testers meeting","Verify that actual value equals expected value");

        WebElement start = driver.findElement(By.xpath("//*[.='Nov 27, 2019, 9:30 AM']"));
        Assert.assertEquals(start.getText(),"Nov 27, 2019, 9:30 AM","Verify that actual date equals to expected date");

        WebElement end = driver.findElement(By.xpath("//*[.='Nov 27, 2019, 10:30 AM']"));
        Assert.assertEquals(end.getText(),"Nov 27, 2019, 10:30 AM","Verify that end date is equal to expected date");

        WebElement allDayEvent = driver.findElement(By.xpath("//*[.='No']"));
        Assert.assertEquals(allDayEvent.getText(),"No","Verify that all day event value is equal expected value");

        WebElement organizer = driver.findElement(By.cssSelector("[class='calendar-event-organizer']"));
        Assert.assertEquals(organizer.getText(),"Stephan Haley","Verify that actual organizer equals to expected organizer");

        WebElement guests = driver.findElement(By.cssSelector("[class='user-status-list list-group']>li>span>a"));
        Assert.assertEquals(guests.getText(),"Tom Smith","Verify that actual guests are expected guests");

        WebElement recurrence = driver.findElement(By.xpath("//*[.='Weekly every 1 week on Wednesday']"));
        Assert.assertEquals(recurrence.getText(),"Weekly every 1 week on Wednesday","Verify that actual recurrence is equal to expected recurrence");

        WebElement callViaHangout = driver.findElement(By.xpath("(//*[contains(text(),'No')])[6]"));
        Assert.assertEquals(callViaHangout.getText(),"No","Verify that call via hangout is expected call");
    }


}
