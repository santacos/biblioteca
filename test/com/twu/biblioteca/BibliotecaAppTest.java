package com.twu.biblioteca;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_have_welcome_message_when_app_is_started() {
        bibliotecaApp.showWelcomeMessage();
        assertThat("Message should contain 'Welcome' when app is started", outContent.toString(), containsString("Welcome"));
    }

    @Test
    public void should_have_a_list_of_options_appear_after_welcome_message() {
        bibliotecaApp.showMenu();
        assertThat("Message should contain 'see the list of library books'", outContent.toString(), containsString("see the list of all library books"));
    }

    @Test
    public void should_have_available_book_lists_appear_when_choose_the_first_option()  {
        bibliotecaApp.chooseOption("1");
        assertThat("Lists should appear with the detail of first book",
                    outContent.toString(),
                    containsString(new Book("Math", "Bob", "1994").getDetail()
                    ));

        assertThat("Lists should appear with the detail of second book",
                    outContent.toString(),
                    containsString(new Book("Sci", "Alice", "1995").getDetail()
                    ));

        assertThat("Lists should appear with the detail of third book",
                outContent.toString(),
                containsString(new Book("English", "Red", "1996").getDetail()
                ));
    }

    @Test
    public void should_have_available_movie_lists_appear_when_choose_the_second_option()  {
        bibliotecaApp.chooseOption("2");
        assertThat("Lists should appear with the detail of first movie",
                outContent.toString(),
                containsString(new Movie("movie1", "1959", "James", "0").getDetail()
                ));

        assertThat("Lists should appear with the detail of second movie",
                outContent.toString(),
                containsString(new Movie("movie2", "1960", "Alice", "1").getDetail()
                ));

        assertThat("Lists should appear with the detail of third movie",
                outContent.toString(),
                containsString(new Movie("movie3", "1961", "Bob", "10").getDetail()
                ));
    }

    @Test
    public void should_have_user_login_when_choose_login_option() {
        bibliotecaApp.loginUser("333-3333", "1234");
        assertTrue("Current user should not be null object", bibliotecaApp.getCurrentUser() != null);
        assertThat("Current user should be Job", bibliotecaApp.getCurrentUser().getName(), containsString("Job"));
    }

    @Test
    public void should_be_able_to_logOut_user_after_user_is_logged_in() {
        bibliotecaApp.loginUser("333-3333", "1234");
        User user = bibliotecaApp.getCurrentUser();
        assertTrue("Current user should be able to log out successfully", bibliotecaApp.logoutUser());
        assertFalse("User should have login status to be false", user.isLoggedIn());
        assertTrue("Current user should be null after user is logged out", bibliotecaApp.getCurrentUser() == null);
    }
}