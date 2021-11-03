package com.telran.contact.tests;

import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isLoginTabPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(priority = 2)
    public void loginRegisteredUserPositiveTest() {

        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());

        app.getUser().login(new User()
                .setEmail("LisaAlisaLA@gmail.com")
                .setPassword("LiAl12345~"));

        Assert.assertTrue(app.getUser().isSignOutTabPresent());
    }

    @Test(priority = 1)
    public void loginRegisteredUserNegativeWithWrongPasswordTest() {

        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());

        app.getUser().login(new User()
                .setEmail("LisaAlisaLA@gmail.com")
                .setPassword("LiAl12345"));

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
