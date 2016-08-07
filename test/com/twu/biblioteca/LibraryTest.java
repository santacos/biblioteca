package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by santacos on 8/7/2016 AD.
 */
public class LibraryTest {
    Library library;
    ArrayList<Book> books;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
        books.add(new Book("book1", "Ben", "1994"));
        books.add(new Book("book2", "Ben", "1995"));

        library = new Library("Biblioteca", books);

    }

    @Test
    public void createLibrary(){
        assertEquals("Biblioteca", library.getName());
    }

    @Test
    public void findBookByNameShouldReturnBookCorrectly(){
        assertEquals(new Book("book1", "Ben", "1994"), library.findBookByName("book1"));
    }

    @Test
    public void checkOutBookByNameSuccessfully(){
        assertTrue(library.checkOutBookByName("book1"));
        Book _book1 = library.findBookByName("book1");
        assertTrue(_book1.isCheckedOut());
    }

    @Test
    public void checkOutNotFoundBookByNameShouldReturnFalse(){
        assertFalse(library.checkOutBookByName("book3"));
    }
}
