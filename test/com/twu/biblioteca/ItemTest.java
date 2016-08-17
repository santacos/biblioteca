package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ItemTest {
    @Test
    public void should_have_book_as_instance_of_item() {
        assertTrue("Book class should be instance of item", (new Book("book1", "ben", "1999")) instanceof Item);
    }


    @Test
    public void should_have_movie_as_instance_of_item() {
        assertTrue("Movie class should be instance of item", (new Movie("movie1", "1999", "James", "0")) instanceof Item);
    }

    @Test
    public void should_have_borrower_after_item_was_checked_out() {
        User user = new User("user1", "a@g.com", "Thailand", "08-999-9999");
        Item item = new Item();
        item.checkOut(user);
        assertTrue("Borrower of this item should be set after it was checked out", item.getBorrower() != null);
    }

    @Test
    public void should_not_have_borrower_after_item_was_return(){
        User user = new User("user1", "a@g.com", "Thailand", "08-999-9999");
        Item item = new Item();
        item.checkOut(user);
        item.returnItem();
        assertTrue("Borrower of this item should not be set after it was return", item.getBorrower() == null);
    }
}
