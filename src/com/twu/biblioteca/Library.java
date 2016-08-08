package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Book> findBookByName(String name) {
        for(Book book: books){
            if(book.getName().equals(name)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }


    public boolean checkOutBookByName(String name) {
        Optional<Book> book = findBookByName(name);
        if(book.isPresent()){
            Book checkedOutBook = book.get();
            boolean isCheckedOutSuccessfully = checkedOutBook.checkOut();
            return isCheckedOutSuccessfully;
        }else{
            return false;
        }


    }
}
