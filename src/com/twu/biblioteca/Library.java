package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


public class Library {
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
        this.movies = new ArrayList<>();
    }

    public Library(String name, ArrayList<Book> books, ArrayList<Movie> movies) {
        this.name = name;
        this.books = books;
        this.movies = movies;
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

    public boolean returnBookByName(String name) {
        Optional<Book> book = findBookByName(name);
        if(book.isPresent()){
            Book returningBook = book.get();
            boolean isReturnBookSuccessfully = returningBook.returnItem();
            return isReturnBookSuccessfully;
        }else{
            return false;
        }
    }


    public ArrayList<Book> getAllAvailableBooks() {
        return books
                .stream()
                .filter(book -> !book.isCheckedOut())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Movie> getAllAvailableMovies() {
        return movies
                .stream()
                .filter(movie -> !movie.isCheckedOut())
                .collect(Collectors.toCollection(ArrayList::new));
    }



    public boolean checkOutMovieByName(String name) {
        Optional<Movie> movie = findMovieByName(name);
        if(movie.isPresent()){
            Movie checkedOutBook = movie.get();
            boolean isCheckedOutSuccessfully = checkedOutBook.checkOut();
            return isCheckedOutSuccessfully;

        }else{
            return false;
        }
    }

    public Optional<Movie> findMovieByName(String name) {
        for(Movie movie: movies){
            if(movie.getName().equals(name)){
                return Optional.of(movie);
            }
        }
        return Optional.empty();
    }
}
