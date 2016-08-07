package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santacos on 8/7/2016 AD.
 */
public class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public Book findBookByName(String name) {
        for(Book book: books){
            if(book.getName().equals(name)){
                return book;
            }
        }
        return null;
    }


    public boolean checkOutBookByName(String name) {
        Book book = findBookByName(name);
        if(book == null)
            return false;

        boolean isCheckedOutSuccessfully = book.checkOut();
        return isCheckedOutSuccessfully;
    }
}
