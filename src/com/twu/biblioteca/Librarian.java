package com.twu.biblioteca;

public class Librarian extends User {
    public Librarian(String name, String email, String address, String phoneNumber) {
        super(name, email, address, phoneNumber);
    }

    public Librarian(String name, String email, String address, String phoneNumber, String username, String password) {
        super(name, email, address, phoneNumber, username, password);
    }
}
