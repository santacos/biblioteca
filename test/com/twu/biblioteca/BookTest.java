package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by santacos on 8/7/2016 AD.
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("book", "Ben", "1994");
    }

    @Test
    public void createBookCorrectly(){
        assertEquals("book", book.getName());
        assertEquals("Ben", book.getAuthor());
        assertEquals("1994", book.getPublishedYear());
        assertEquals(false, book.isCheckedOut());
    }

    @Test
    public void checkOutAvailableBookSuccessfully(){
        assertTrue(book.checkOut());
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void checkOutUnavailableBookShouldReturnFalse(){
        assertTrue(book.checkOut());
        assertFalse(book.checkOut());
    }

    @Test
    public void returnCheckedOutBookShouldReturnTrue() throws Exception {
        book.checkOut();
        assertTrue(book.returnBook());
    }

    @Test
    public void returnWrongBookShouldReturnFalse() throws Exception {
        assertFalse(book.returnBook());
    }

    @Test
    public void getDetailOfTheBook() throws Exception {
        String detail = book.getDetail();
        System.out.println(detail);
        assertTrue( detail.contains( book.getName() ));
        assertTrue( detail.contains( book.getAuthor() ));
        assertTrue( detail.contains( book.getPublishedYear() ));

    }

}
