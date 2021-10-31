package com.telran.contact;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends  TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginTabPresent()) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {

        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());

        type(By.cssSelector("[placeholder='Email']"), "LisaAlisaLA@gmail.com");

        type(By.cssSelector("[placeholder='Password']"), "LiAl12345~");

        click(By.xpath("//button[contains(.,'Login')]"));
        Assert.assertTrue(isSignOutTabPresent());
    }

    @Test
    public void loginRegisteredUserNegativeWithWrongPasswordTest() {

        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());

        type(By.cssSelector("[placeholder='Email']"), "LisaAlisaLA@gmail.com");

        type(By.cssSelector("[placeholder='Password']"), "LiAl12345");

        click(By.xpath("//button[contains(.,'Login')]"));
        Assert.assertTrue(isAlertPresent());
    }

}
