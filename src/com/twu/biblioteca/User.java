package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private boolean isLoggedIn;
    private UserCredential userCredential;


    public User(String name, String email, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isLoggedIn = false;
    }

    public User(String name, String email, String address, String phoneNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isLoggedIn = false;
        this.userCredential = new UserCredential(username, password);
    }

    public static String getHeaderDetail() {
        String header = String.format("%1$-10s %2$10s %3$10s %4$10s", "Name", "Email", "Address", "Phone number");
        return header;
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

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
    }


    public String getName() {
        return name;
    }

    public boolean checkPassword(String password) {
        return userCredential.checkPassword(password);
    }

    public void logOut() {
        this.isLoggedIn = false;
    }
}
