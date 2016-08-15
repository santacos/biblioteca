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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!name.equals(movie.name)) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;
        return director != null ? director.equals(movie.director) : movie.director == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        return result;
    }

    public static String getHeaderOfDetail() {
        String header = String.format("%1$-10s %2$10s %3$10s %4$10s", "Name", "Year", "Director", "Rating");
        return header;
    }
}
