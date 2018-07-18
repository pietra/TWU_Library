package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaAppUI {
    public static void WelcomeMessage() {
        System.out.println("*************************************");
        System.out.println("************* Welcome to ************");
        System.out.println("***** Library Management System *****");
        System.out.println("** of The Bangalore Public Library **");
        System.out.println("*************************************");
    }

    public static void MenuMessageCustomer() {
        System.out.println();
        System.out.println("***** Menu Options For Customer *****");
        System.out.println("            List Books - 1           ");
        System.out.println("          Check out book - 2         ");
        System.out.println("            Return book - 3          ");
        System.out.println("            List Movies - 4          ");
        System.out.println("          Check out movie - 5        ");
        System.out.println("            Return movie - 6         ");
        System.out.println("              Quit - 13              ");
        System.out.println("*************************************");
    }

    public static void MenuMessageLibrarian() {
        System.out.println();
        System.out.println("***** Menu Options For Librarian ****");
        System.out.println("      List books checked out - 1     ");
        System.out.println("              Quit - 13              ");
        System.out.println("*************************************");
    }

    /* Login messages */
    public static void LoginMessage() {
        System.out.println();
        System.out.println("Insira <library_number> + space + <password>: ");
    }

    public static void LoginSuccessMessage() {
        System.out.println("You're logged in.");
    }

    public static void LoginFailedMessage(String reason) {
        System.out.println("Ops, login failed: " + reason);
    }


    /* Book operations messages */
    public static void ListBooksMessage() {
        System.out.println("List of books");
    }

    public static void CheckoutBookMessage() {
        System.out.println("Do you wanna checkout a book? Type its name: ");
    }

    public static void CheckoutBookSuccess(String bookName) {
        System.out.println("Congratulations! You checked out " + bookName + ".");
    }

    public static void CheckoutBookFail(String bookName) {
        System.out.println("Oh, no! " + bookName + " isn't available.");
    }

    public static void ReturnBookMessage() {
        System.out.println("Do you wanna return a book? Type its name: ");
    }

    public static void ReturnBookSuccess(String bookName) {
        System.out.println("Nice! You returned " + bookName + ".");
    }

    public static void ReturnBookFail(String bookName) {
        System.out.println("What? " + bookName + " was already available.");
    }

    /* Movie operations messages */
    public static void ListMoviesMessage() {
        System.out.println("List of movies");
    }

    public static void CheckoutMovieMessage() {
        System.out.println("Do you wanna checkout a movie? Type its name: ");
    }

    public static void CheckoutMovieSuccess(String movieName) {
        System.out.println("Congratulations! You checked out " + movieName + ".");
    }

    public static void CheckoutMovieFail(String movieName) {
        System.out.println("Oh, no! " + movieName + " isn't available.");
    }

    public static void ReturnMovieMessage() {
        System.out.println("Do you wanna return a movie? Type its name: ");
    }

    public static void ReturnMovieSuccess(String movieName) {
        System.out.println("Nice! You returned " + movieName + ".");
    }

    public static void ReturnMovieFail(String movieName) {
        System.out.println("What? " + movieName + " was already available.");
    }

    public static void QuitMessage() {
        System.out.println("Goodbye! See you soon!");
    }

    public static int ReadInteger() {
        Scanner number = new Scanner(System.in);
        return number.nextInt();
    }

    public static String ReadBookName() {
        Scanner book = new Scanner(System.in);
        return book.nextLine();
    }

    public static String ReadMovieName() {
        Scanner book = new Scanner(System.in);
        return book.nextLine();
    }

    public static String ReadLoginInformation() {
        Scanner line = new Scanner(System.in);
        return line.nextLine();
    }

    public static String[] ParseLoginInformation(String userInformation) {
        String[] parsedUserInformation = new String[2];
        String[] tokens = userInformation.split(" ");
        parsedUserInformation[0] = tokens[0];
        parsedUserInformation[1] = tokens[1];
        return parsedUserInformation;
    }

    public static String[] ReadAndParseLoginInformation() {
        String userInformation = ReadLoginInformation();
        return ParseLoginInformation(userInformation);
    }

    public static void ListBooks(ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getAvailable()) {
                System.out.print(book.getName() + " | ");
                System.out.print(book.getAuthor() + " | ");
                System.out.print(book.getYearPublished());
                System.out.println();
            }
        }
    }

    public static void ListMovies(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            if (movie.getAvailable()) {
                System.out.print(movie.getName() + " | ");
                System.out.print(movie.getDirector() + " | ");
                System.out.print(movie.getYear() + " | ");
                System.out.print(movie.getRating());
                System.out.println();
            }
        }
    }

    public static void ListBooksCheckedOutMessage() {
        System.out.println("Books checked out: ");
    }

    public static void ListBooksCheckedOutAndWhoDid(ArrayList<Book> booksCheckedOut) {
        for (Book book : booksCheckedOut) {
            System.out.println("Book name: " + book.getName());
        }
    }

}
