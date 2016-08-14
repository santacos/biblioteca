package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserTest {
    String name = "Tony";
    String email = "Tony@gmail.com";
    String address = "Bangkok Thailand";
    String phoneNumber = "02-555-5555";

    User user = new User(name, email, address, phoneNumber);

    @Test
    public void should_have_all_user_information() {
        assertThat("information of user should contain name of user", user.getUserInformation(), containsString(name));
        assertThat("information of user should contain email of user", user.getUserInformation(), containsString(email));
        assertThat("information of user should contain address of user", user.getUserInformation(), containsString(address));
        assertThat("information of user should contain phone number of user", user.getUserInformation(), containsString(phoneNumber));
    }

    @Test
    public void should_be_not_logged_in_when_User_object_was_created(){
        assertFalse("status of user's logIn should be false when object was created", user.isLoggedIn());
    }

    @Test
    public void should_be_logged_in_after_user_signed_in() {
        user.logIn();
        assertTrue("status of user's logIn should be true after user logged in", user.isLoggedIn());
    }
}
