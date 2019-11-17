package com.cybertek.tests.day7_testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterTest {

    @Test
    public void test1(){

        // --> beginning of the each test
        //Webdriver code
        //open browser
        //some settings before test

        //after each
        //close browser

    }

    @BeforeMethod
    public void setUpMethod(){

        System.out.println("BEFORE METHOD");
        System.out.println("OPENING THE BROWSER");
    }
}
