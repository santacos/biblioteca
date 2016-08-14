package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private boolean isLoggedIn;



    public User(String name, String email, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isLoggedIn = false;
    }

    public String getUserInformation() {
        String detail = String.format("%1$-10s %2$10s %3$10s %4$10s", this.name, this.email, this.address, this.phoneNumber);
        return detail;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }


    public void logIn() {
        this.isLoggedIn = true;
    }
}
