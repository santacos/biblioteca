package com.twu.biblioteca;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ItemTest {
    @Test
    public void should_have_book_as_instance_of_item() {
        assertTrue("Book class should be instance of item", (new Book("book1", "ben", "1999")) instanceof Item);

    }
}
