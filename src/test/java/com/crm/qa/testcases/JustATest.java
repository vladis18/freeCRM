package com.crm.qa.testcases;

import org.testng.annotations.Test;

public class JustATest {
    @Test
    public void test(){
        System.out.println(System.getProperty("os.name")+ " THIS IS MY CHURCH, THIS IS WHERE I HEAL MY HURTS");
        System.out.println(System.getProperty("user.name")+ " IS IS MY USER");
        System.out.println(System.getProperty("user.dir")+ "  IS IS MY Directory");
    }
}
