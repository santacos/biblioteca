package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        books.add(new Book("book1", "Ben", "1994"));
        books.add(new Book("book2", "Ben", "1995"));
        books.add(new Book("book3", "Ben", "1995"));

        movies = new ArrayList<>();
        movies.add(new Movie("movie1", "1959", "James", "0"));
        movies.add(new Movie("movie2", "1960", "Alice", "1"));
        movies.add(new Movie("movie3", "1961", "Bob", "10"));

        users = new ArrayList<>();
        users.add(new User("user1", "a@g.com", "Thailand", "08-999-9999"));
        users.add(new User("user2", "b@g.com", "England", "08-999-9999"));
        users.add(new User("user3", "c@g.com", "Singapore", "08-999-9999"));

        library = new Library("Biblioteca", books);

    }

    @Test
    public void should_be_found_book_when_book_is_valid_in_library(){
        assertEquals("valid book should be found when search book by name", new Book("book1", "Ben", "1994"), library.findBookByName("book1").get());
    }

    @Test
    public void should_be_able_to_check_out_book_when_book_is_exist_and_available_in_library(){
        assertTrue("valid book should be able to be checked out successfully", library.checkOutBookByName("book1"));

    }

    @Test
    public void should_not_be_able_to_check_out_book_when_book_is_invalid_in_library(){
        assertFalse("invalid book can not be checked out", library.checkOutBookByName("notFoundBook"));
    }

    @Test
    public void should_be_able_to_return_book_when_book_is_exist_and_be_checked_out_in_library() {
        library.checkOutBookByName("book1");
        assertTrue("valid book should be returned to library successfully", library.returnBookByName("book1"));
        Book _book1 = library.findBookByName("book1").get();
        assertFalse("book should be available after it is returned", _book1.isCheckedOut());
    }

    @Test
    public void should_return_all_available_books_in_library() {
        library.checkOutBookByName("book1");
        ArrayList<Book> expectedList = new ArrayList<>();
        expectedList.add(new Book("book3", "Ben", "1995"));
        expectedList.add(new Book("book2", "Ben", "1995"));


        assertThat("all available books should be appeared in the list",
                library.getAllAvailableBooks(), containsInAnyOrder(expectedList.toArray()));
    }


}
