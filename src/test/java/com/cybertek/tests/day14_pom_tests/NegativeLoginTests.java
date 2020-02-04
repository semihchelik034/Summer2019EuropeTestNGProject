package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {

        @Test
        public void wrongPasswordTest(){
            LoginPage loginPage = new LoginPage();

            loginPage.usernmaeInput.sendKeys("user1");
            loginPage.passwordInput.sendKeys("UserUser1234");
            loginPage.loginBtn.click();


            Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        }

        @Test
        public void wrongUsername(){
            LoginPage loginPage = new LoginPage();

            loginPage.login("useruser123","UserUser123");

            Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        }

}
