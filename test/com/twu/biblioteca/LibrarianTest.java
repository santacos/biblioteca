package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibrarianTest {

    @Test
    public void should_have_librarian_as_instance_of_user() {

        assertTrue("Book class should be instance of item", (new Librarian("Job", "j@g.com", "Bangkok Thailand", "09-333-3333", "333-3333", "1234")) instanceof User);
    }
}