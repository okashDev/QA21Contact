package com.telran.contact.tests;

import com.telran.contact.models.User;
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
        if (!app.getUser().isLoginTabPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void registrationPositiveTest() {
    //    click By.xpath("//a[contains(.,'LOGIN')]")
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());

        app.getUser().createNewAccount(new User()
                .setEmail("LisaAlisaLA@gmail.com")
                .setPassword("LiAl12345~"));

        Assert.assertTrue(app.getUser().isSignOutTabPresent());
    }

    @Test
    public void registrationNegativeWithoutPasswordTest() {
    //    click By.xpath("//a[contains(.,'LOGIN')]")
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());

        app.getUser().createNewAccount(new User()
                .setEmail("LisaAlisaLA@gmail.com"));
        //        .setPassword("LiAl12345~"));

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
