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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return publishedYear != null ? publishedYear.equals(book.publishedYear) : book.publishedYear == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishedYear != null ? publishedYear.hashCode() : 0);
        return result;
    }

    public boolean returnBook() {
        boolean isReturnSuccessfully = false;
        if(isCheckedOut){
            this.isCheckedOut = false;
            isReturnSuccessfully = true;
        }
        return isReturnSuccessfully;
    }

    public String getDetail() {
        String detail = String.format("%1$-10s %2$10s %3$10s", this.name, this.author, this.publishedYear);
        return detail;
    }
}
