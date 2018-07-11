package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaApp {

    private static Biblioteca biblioteca = new Biblioteca();
    private static Boolean available;
    private static Map<Integer, Runnable> options = new HashMap<>();

    public static void main(String[] args) {
        InitializingMenu();
        BibliotecaAppUI.WelcomeMessage();
        Menu();
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

    private static void Quit() {
        BibliotecaAppUI.QuitMessage();
        available = false;
    }

    private static void InitializingMenu() {
        available = true;
        options.put(1, BibliotecaApp::ListBooks);
        options.put(2, BibliotecaApp::TryToCheckoutBook);
        options.put(3, BibliotecaApp::TryToReturnBook);
        options.put(13, BibliotecaApp::Quit);
    }

}
