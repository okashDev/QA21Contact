package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    // preconditions: user should be logged out
    // click on Login
    // fill registration form
    // click on Registration button
    // check Logout button disployed

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginTabPresent()) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void registrationPositiveTest() {
    //    click By.xpath("//a[contains(.,'LOGIN')]")
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());

        type(By.cssSelector("[placeholder='Email']"), "LisaAlisaLA@gmail.com");

        type(By.cssSelector("[placeholder='Password']"), "LiAl12345~");

        click(By.xpath("//button[contains(.,'Registration')]"));
        Assert.assertTrue(isSignOutTabPresent());
    }

}
