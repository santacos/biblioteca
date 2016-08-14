package com.twu.biblioteca;

public class Movie extends Item{
    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        String detail = String.format("%1$-10s %2$10s %3$10s %4$10s", this.name, this.year, this.director, this.rating);
        return detail;
    }
}
