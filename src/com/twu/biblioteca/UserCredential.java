package com.twu.biblioteca;

public class UserCredential {
    private String libraryNumber;
    private String password;

    public UserCredential(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }


    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
