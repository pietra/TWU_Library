package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaApp {

    private static Biblioteca biblioteca = new Biblioteca();
    private static LoginManager loginManager = new LoginManager();
    private static Boolean available;
    private static Map<Integer, Runnable> options = new HashMap<>();

    public static void main(String[] args) {
        InitializingMenu();
        BibliotecaAppUI.WelcomeMessage();
        Login();
        Menu();
    }

    private static void Login() {
        while (!available) {
            try {
                BibliotecaAppUI.LoginMessage();
                String[] userInformation = BibliotecaAppUI.ReadAndParseLoginInformation();
                loginManager.Login(userInformation[0], userInformation[1]);
            } catch (IOException ex) {
                BibliotecaAppUI.LoginFailedMessage("some information is wrong.");
                continue;
            } catch (IndexOutOfBoundsException ex) {
                BibliotecaAppUI.LoginFailedMessage("some information is missing.");
                continue;
            }
            available = true;
        }
        BibliotecaAppUI.LoginSuccessMessage();
    }

    private static void Menu() {
        while (available) {
            BibliotecaAppUI.MenuMessage();
            int option = BibliotecaAppUI.ReadInteger();
            RunMenuOption(option);
        }
    }

    private static void RunMenuOption(int option) {
        options.get(option).run();
    }

    private static void ListBooks() {
        ArrayList<Book> books = biblioteca.getBooks();
        BibliotecaAppUI.ListBooksMessage();
        BibliotecaAppUI.ListBooks(books);
    }

    private static void ListMovies() {
        ArrayList<Movie> movies = biblioteca.getMovies();
        BibliotecaAppUI.ListMoviesMessage();
        BibliotecaAppUI.ListMovies(movies);
    }

    private static void TryToCheckoutBook() {
        try {
            BibliotecaAppUI.CheckoutBookMessage();
            String bookName = BibliotecaAppUI.ReadBookName();
            Boolean success = biblioteca.CheckoutBook(bookName);
            if (success)
                BibliotecaAppUI.CheckoutBookSuccess(bookName);
            else
                BibliotecaAppUI.CheckoutBookFail(bookName);
        } catch (IOException ex) {
            System.out.println("We don't have this book.");
        }
    }

    private static void TryToCheckoutMovie() {
        try {
            BibliotecaAppUI.CheckoutMovieMessage();
            String movieName = BibliotecaAppUI.ReadMovieName();
            Boolean success = biblioteca.CheckoutMovie(movieName);
            if (success)
                BibliotecaAppUI.CheckoutMovieSuccess(movieName);
            else
                BibliotecaAppUI.CheckoutMovieFail(movieName);
        } catch (IOException ex) {
            System.out.println("We don't have this movie.");
        }
    }

    private static void TryToReturnBook() {
        try {
            BibliotecaAppUI.ReturnBookMessage();
            String bookName = BibliotecaAppUI.ReadBookName();
            Boolean success = biblioteca.ReturnBook(bookName);
            if (success)
                BibliotecaAppUI.ReturnBookSuccess(bookName);
            else
                BibliotecaAppUI.ReturnBookFail(bookName);
        } catch (IOException ex) {
            System.out.println("We don't have this book.");
        }
    }

    private static void TryToReturnMovie() {
        try {
            BibliotecaAppUI.ReturnMovieMessage();
            String movieName = BibliotecaAppUI.ReadMovieName();
            Boolean success = biblioteca.ReturnMovie(movieName);
            if (success)
                BibliotecaAppUI.ReturnMovieSuccess(movieName);
            else
                BibliotecaAppUI.ReturnMovieFail(movieName);
        } catch (IOException ex) {
            System.out.println("We don't have this movie.");
        }
    }

    private static void Quit() {
        BibliotecaAppUI.QuitMessage();
        available = false;
    }

    private static void InitializingMenu() {
        available = false;
        options.put(1, BibliotecaApp::ListBooks);
        options.put(2, BibliotecaApp::TryToCheckoutBook);
        options.put(3, BibliotecaApp::TryToReturnBook);
        options.put(4, BibliotecaApp::ListMovies);
        options.put(5, BibliotecaApp::TryToCheckoutMovie);
        options.put(6, BibliotecaApp::TryToReturnMovie);
        options.put(13, BibliotecaApp::Quit);
    }

}
