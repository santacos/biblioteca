package com.twu.biblioteca;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by amornthip on 17/08/2016.
 */
public class RentableItemTest {
    Book book = new Book("Math", "Bob", "1994");
    RentableItem<Book> rentableBook = new RentableItem<>(book);

    @Test
    public void should_have_available_status_when_item_was_instantiated() {
        assertFalse("default check out status of item should be false", rentableBook.isCheckedOut());
    }

    @Test
    public void should_be_able_to_checkOut_item_when_item_is_available() {
        assertTrue("the item should be able to check out when it is available", rentableBook.checkOut());
    }

    @Test
    public void should_not_be_able_to_checkOut_again_book_after_book_was_checkedOut(){
        rentableBook.checkOut();
        assertFalse("item should not be able to check out again after the item was checked out", rentableBook.checkOut());
    }

    @Test
    public void should_be_able_to_return_book_after_book_was_checkedOut() {
        rentableBook.checkOut();
        assertTrue("item can be returned after the item was checked out", rentableBook.returnItem());
    }

    @Test
    public void should_not_be_able_to_return_book_when_book_is_not_checkedOut() {
        assertFalse("available item can not be returned", rentableBook.returnItem());
    }

}
