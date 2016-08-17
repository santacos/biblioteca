package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;


public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("book", "Ben", "1994");
    }

    @Test
    public void should_generate_Book_with_default_status_when_instantiate_book(){
        assertEquals("name of book should be the same with name that was instantiated", "book", book.getName());
        assertEquals("author of book should be the same with the author that was instantiated", "Ben", book.getAuthor());
        assertEquals("published year of book should be the same with year that was instantiated", "1994", book.getPublishedYear());
    }


    @Test
    public void should_have_all_detail_of_the_book_when_call_get_detail_method()  {
        String detail = book.getDetail();
        assertTrue( "detail should have name of book", detail.contains( book.getName() ));
        assertTrue( "detail should have author of book", detail.contains( book.getAuthor() ));
        assertTrue( "detail should have published year of book", detail.contains( book.getPublishedYear() ));
    }

    @Test
    public void should_have_header_of_detail_when_call_getter_detail_of_movie() throws Exception {

        assertThat("header should have name", book.getHeaderOfDetail(), containsString("Name"));
        assertThat("header should have author", book.getHeaderOfDetail(), containsString("Author"));
        assertThat("header should have published year", book.getHeaderOfDetail(), containsString("Published year"));
    }

}
