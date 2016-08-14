package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private Library library;

    public BibliotecaApp() {
        ArrayList<Book> books = new ArrayList<Book>(){{
            add(new Book("Math", "Bob", "1994"));
            add(new Book("Sci", "Alice", "1995"));
            add(new Book("English", "Red", "1996"));
        }};

        library = new Library("Biblioteca", books);
    }

    public void start() {
        showWelcomeMessage();
        initMenu();
    }

    private void initMenu() {
        showMenu();

        while (true){
            String option = getInputFromKeyboard(new Scanner(System.in));
            chooseOption(option);
            pressAnyKeyToBackToMenu();
        }
    }

    public void showWelcomeMessage() {
        System.out.println(MessageTranslator.welcomeMessage);
    }


    public void showMenu() {
        System.out.println("------Menu : select option ---------");
        System.out.println("[1] see the list of all library books");
        System.out.println("[2] check out the book");
        System.out.println("[3] return the book");
        System.out.println("[Quit] exit application");
        System.out.print("Selected Option: ");
    }

    public void chooseOption(String chosenOption) {
        chosenOption = chosenOption.toLowerCase();
        switch (chosenOption) {
            case "1" :
                showAllAvailableBook();
                break;
            case "2":
                checkOutBook();
                break;
            case "3":
                returnBook();
                break;
            case "quit":
                System.exit(0);
            default:
                System.out.println(MessageTranslator.OptionIsInvalid);
                break;
        }
    }

    private void returnBook() {
        System.out.println(MessageTranslator.RETURN_THE_BOOK);
        System.out.print(MessageTranslator.ENTER_NAME_OF_THE_BOOK);
        String book_name = getInputFromKeyboard(new Scanner(System.in));
        boolean isReturnSuccessfully = library.returnBookByName(book_name);
        if(isReturnSuccessfully)
            System.out.println(MessageTranslator.successfulReturn);
        else
            System.out.println(MessageTranslator.unsuccessfulReturn);
    }

    private void checkOutBook() {
        System.out.println(MessageTranslator.CHECK_OUT_THE_BOOK);
        System.out.print(MessageTranslator.ENTER_NAME_OF_THE_BOOK);
        String name = getInputFromKeyboard(new Scanner(System.in));
        boolean isCheckOutSuccessfully = library.checkOutBookByName(name);
        if(isCheckOutSuccessfully)
            System.out.println(MessageTranslator.successfulCheckOut);
        else
            System.out.println(MessageTranslator.unsuccessfulCheckOut);
    }

    private void showAllAvailableBook() {
        System.out.println(MessageTranslator.LIST_OF_ALL_LIBRARY_BOOKS);

        for(Book book: library.getAllAvailableBooks()){
            System.out.println(book.getDetail());
        }
    }

    private String getInputFromKeyboard(Scanner in) {
        String option = in.next().trim();
        return option;
    }

    private void pressAnyKeyToBackToMenu() {
        System.out.println(MessageTranslator.pressEnterToBackToMenu);
        try {
            System.in.read();
        }catch (Exception e){
            System.out.println(MessageTranslator.OptionIsInvalid);
            initMenu();
        }
        showMenu();
    }


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
