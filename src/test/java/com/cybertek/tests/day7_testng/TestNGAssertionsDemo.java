package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){

        Assert.assertFalse("emails@".contains("@"),"Verify @");

        Assert.assertNotEquals("5.51","6.00","Break time!");
    }
}
