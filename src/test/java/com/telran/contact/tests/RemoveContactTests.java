package com.telran.contact.tests;

import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void unsurePreconditions(){
        if (!app.getUser().isSignOutTabPresent()) {
            app.getUser().clickOnLoginTab();
            app.getUser().login(new User()
                    .setEmail("LisaAlisaLA@gmail.com")
                    .setPassword("LiAl12345~"));
        }

        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        app.getContact().addNewContact(new Contact().setName("Mery")
                .setSurName("Poppins")
                .setPhone("12345" + i)
                .setEmail("poppi" + i + "@gmail.com")
                .setAddress("Berlin")
                .setDescription("torwart"));

 //               "Mery", "12345" + i, "poppi" + i + "@gmail.com", "Berlin", "torwart"));
//        click(By.cssSelector("a:nth-child(5)"));
//        pause(1000);
//        type(By.cssSelector("[placeholder='Name']"), "Mery");
//        type(By.cssSelector("input:nth-child(2)"), "Poppins");
//        type(By.cssSelector("input:nth-child(3)"), "12345" + i);
//        type(By.cssSelector("input:nth-child(4)"), "poppi" + i + "@gmail.com");
//        type(By.cssSelector("input:nth-child(5)"), "Berlin");
//        type(By.cssSelector("input:nth-child(6)"), "torwart");
//        //jump();
//        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);
        app.getContact().removeContact();
     //   Thread.sleep(2000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);

        Assert.assertEquals(sizeBefore, sizeAfter);
    }

}
