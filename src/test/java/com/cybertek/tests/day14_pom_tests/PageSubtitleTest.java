package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

        @Test
        public void verifySubtitleTest(){
            LoginPage loginPage = new LoginPage();
            loginPage.login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));

            DashboardPage dashboardPage = new DashboardPage();
            Assert.assertEquals(dashboardPage.getPageSubTitle(),"Quick Launchpad","Verify that page subtitle is quick launchpad");

            dashboardPage.navigateToModule("Activities","Calendar Events");

            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
            Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify that page subtitle is calendar events");
        }
}
