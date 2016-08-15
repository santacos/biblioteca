package com.twu.biblioteca;


public class Book extends Item {
    private String name;
    private String author;
    private String publishedYear;

    public Book(String name, String author, String publishedYear) {
        super();
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
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



    public String getDetail() {
        String detail = String.format("%1$-10s %2$10s %3$10s", this.name, this.author, this.publishedYear);
        return detail;
    }

    public static String getHeaderOfDetail() {
        String header = String.format("%1$-10s %2$10s %3$10s", "Name", "Author", "Published year");
        return header;
    }
}
