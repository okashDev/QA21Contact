package com.telran.contact.tests;

import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isSignOutTabPresent()) {
            app.getUser().clickOnLoginTab();
            app.getUser().login(new User()
                    .setEmail("LisaAlisaLA@gmail.com")
                    .setPassword("LiAl12345~"));
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        app.getContact().addNewContact(new Contact().setName("Mery")
                .setSurName("Poppins")
                .setPhone("12345" + i)
                .setEmail("poppi" + i + "@gmail.com")
                .setAddress("Berlin")
                .setDescription("torwart"));
        // click(By.cssSelector(".add_form__2rsm2 button"));

        Assert.assertTrue(app.getContact().isContactCreated("Mery"));

    }

}
