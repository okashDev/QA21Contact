package com.telran.contact.tests;

import org.testng.annotations.Test;

public class OpenHomePageTests extends TestBase {

    @Test
    public void HomePageTest() {
        System.out.println("Site opened!");
        System.out.println("HomeComponent:" + app.getHome().isHomeComponentPresent());
    }

}
