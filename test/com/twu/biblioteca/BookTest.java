package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by santacos on 8/7/2016 AD.
 */
public class BookTest {

    @Test
    public void createBookCorrectly(){
        Book book1 = new Book("book1", "Ben", "1994");
        assertEquals("book1", book1.getName());
        assertEquals("Ben", book1.getAuthor());
        assertEquals("1994", book1.getPublishedYear());
        assertEquals(false, book1.isCheckedOut());
    }

    @Test
    public void checkOutAvailableBookSuccessfully(){
        Book book = new Book("book", "Ben", "1994");
        assertTrue(book.checkOut());
        assertTrue(book.isCheckedOut());
    }







}
