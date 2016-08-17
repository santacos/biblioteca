package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {

    private Library library;
    private HashMap<String, User> members;
    private User currentUser;

    public BibliotecaApp() {
        ArrayList<Book> books = new ArrayList<Book>(){{
            add(new Book("Math", "Bob", "1994"));
            add(new Book("Sci", "Alice", "1995"));
            add(new Book("English", "Red", "1996"));
        }};

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("movie1", "1959", "James", "0"));
        movies.add(new Movie("movie2", "1960", "Alice", "1"));
        movies.add(new Movie("movie3", "1961", "Bob", "10"));

        library = new Library("Biblioteca", books, movies);


        members = new HashMap<String, User>(){{
            put("333-3333", new User("Job", "j@g.com", "Bangkok Thailand", "09-333-3333", "333-3333", "1234"));
            put("233-3333", new User("Ann", "a@g.com", "England", "08-333-2222", "233-3333", "2345"));
        }};
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
            pressEnterToBackToMenu();
        }
    }

    public void showWelcomeMessage() {
        System.out.println(MessageTranslator.welcomeMessage);
    }


    public void showMenu() {
        System.out.println("------Menu : select option ---------");
        System.out.println("[1] see the list of all library books");
        System.out.println("[2] see the list of all library movies");
        if(isCurrentUserLoggedIn()){
            showUserMemberMenu();
        }else{
            System.out.println("[login] Log in");
        }
        System.out.println("[Quit] exit application");
        System.out.println("Enter [option] you would like to select: For example: Enter option: 1 ");
        System.out.print("Enter option: ");
    }

    private boolean isCurrentUserLoggedIn() {
        if(currentUser == null)
            return false;
        return true;
    }

    private void showUserMemberMenu() {
        System.out.println("[3] check out the book");
        System.out.println("[4] return the book");
        System.out.println("[5] see my user information");
        System.out.println("[logout] Log out");
    }

    public void chooseOption(String chosenOption) {
        if(isCurrentUserLoggedIn()){
            chooseOptionWithLogin(chosenOption);
        }else {
            chooseOptionWithoutLogin(chosenOption);
        }
    }

    private void chooseOptionWithLogin(String chosenOption) {
        chosenOption = chosenOption.toLowerCase();
        switch (chosenOption) {
            case "1" :
                showAllAvailableBooks();
                break;
            case "2":
                showAllAvailableMovie();
                break;
            case "3":
                checkOutBook();
                break;
            case "4":
                returnBook();
                break;
            case "5":
                showUserInformation();
                break;
            case "logout":
                logout();
                break;
            case "quit":
                System.exit(0);
            default:
                System.out.println(MessageTranslator.OptionIsInvalid);
                break;
        }
    }

    private void showUserInformation() {
        System.out.println(getUserInformation());
    }

    private void chooseOptionWithoutLogin(String chosenOption) {
        chosenOption = chosenOption.toLowerCase();
        switch (chosenOption) {
            case "1" :
                showAllAvailableBooks();
                break;
            case "2":
                showAllAvailableMovie();
                break;
            case "login":
                login();
                break;
            case "quit":
                System.exit(0);
            default:
                System.out.println(MessageTranslator.OptionIsInvalid);
                break;
        }
    }

    private void logout() {
        logoutUser();
        System.out.println(MessageTranslator.YOU_RE_LOGGED_OUT);
        pressEnterToBackToMenu();
    }

    private void login() {
        System.out.println(MessageTranslator.LOG_IN);
        System.out.print(MessageTranslator.ENTER_USERNAME);
        String username = getInputFromKeyboard(new Scanner(System.in));
        System.out.print(MessageTranslator.ENTER_PASSWORD);
        String password = getInputFromKeyboard(new Scanner(System.in));

        boolean isSuccessfullyLogin = loginUser(username, password);
        if(isSuccessfullyLogin){
            System.out.println(MessageTranslator.YOU_RE_LOGGED_IN);
        }else{
            System.out.println(MessageTranslator.INVALID_USERNAME_PASSWORD);
        }
        pressEnterToBackToMenu();
    }

    private void showAllAvailableMovie() {
        System.out.println(MessageTranslator.LIST_OF_ALL_LIBRARY_MOVIES);
        System.out.println(Movie.getHeaderOfDetail());

        for(Movie movie: library.getAllAvailableMovies()){
            System.out.println(movie.getDetail());
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

    private void showAllAvailableBooks() {
        System.out.println(MessageTranslator.LIST_OF_ALL_LIBRARY_BOOKS);
        System.out.println(Book.getHeaderOfDetail());

        for(Book book: library.getAllAvailableBooks()){
            System.out.println(book.getDetail());
        }
    }

    private String getInputFromKeyboard(Scanner in) {
        String option = in.next().trim();
        return option;
    }

    private void pressEnterToBackToMenu() {
        System.out.println(MessageTranslator.pressEnterToBackToMenu);
        try {
            System.in.read();
        }catch (Exception e){
            System.out.println(MessageTranslator.OptionIsInvalid);
            initMenu();
        }
        initMenu();
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public boolean loginUser(String username, String password) {
        boolean isLoginSuccessfully = false;
        if(members.containsKey(username)){
            User loginUser = members.get(username);
            if(loginUser.checkPassword(password)){
                currentUser = loginUser;
                currentUser.logIn();
                isLoginSuccessfully = true;
            }
        }

        return isLoginSuccessfully;
    }

    public boolean logoutUser() {
        if(this.isCurrentUserLoggedIn()){
            this.currentUser.logOut();
            this.currentUser = null;
        }
        return true;
    }

    public String getUserInformation() {
        String endLine = "\n";
        String result = User.getHeaderDetail() + endLine;
        result += currentUser.getUserInformation();

        return result;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }


}
