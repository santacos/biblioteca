package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserCredentialTest {
    private String username = "Job";
    private String password = "1234";
    UserCredential userCredential = new UserCredential(username, password);

    @Test
    public void should_return_true_when_password_is_correct() {
        assertTrue("should return true when password is correct", userCredential.checkPassword("1234"));

    }

}