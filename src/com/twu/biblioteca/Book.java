package com.twu.biblioteca;

/**
 * Created by santacos on 8/7/2016 AD.
 */
public class Book {
    private String name;
    private String author;
    private String publishedYear;
    private boolean isCheckedOut;

    public Book(String name, String author, String publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isCheckedOut = false;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }


    public boolean isCheckedOut() {
        return isCheckedOut;
    }


    public boolean checkOut() {
        if(!isCheckedOut){
            this.isCheckedOut = true;
            return true;
        }
        return false;
    }
}
