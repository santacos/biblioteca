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
    public void should_have_lists_appear_when_choose_the_first_option()  {
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

    @Ignore
    public void should_be_able_to_check_out_book_when_choose_the_second_option() {
        bibliotecaApp.chooseOption("2");
        assertThat("Check out book should appear after choose the second option",
                outContent.toString(),
                containsString("Check out book"));
    }

    @Ignore
    public void should_be_able_to_return_book_when_choose_the_third_option() {
        bibliotecaApp.chooseOption("3");
        assertThat("Return book should appear after choose the third option",
                outContent.toString(),
                containsString("Return book"));
    }
}