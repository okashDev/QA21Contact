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
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }

    @Test
    public void registrationPositiveTest() {
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));

        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("LisaAlisaYA@gmail.com");

        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("LiAl1234~");

        driver.findElement(By.xpath("//button[contains(.,'Registration')]")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));

    }

}
