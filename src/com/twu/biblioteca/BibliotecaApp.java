package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaApp {

    private static Biblioteca biblioteca = new Biblioteca();
    private static Boolean available = true;
    private static Map<Integer, Runnable> options = new HashMap<>();

    public static void main(String[] args) {
        InitializingMenu();
        BibliotecaAppUI.WelcomeMessage();
        Menu();
    }

    private static void Menu() {
        while (available) {
            BibliotecaAppUI.MenuMessage();
            int read = BibliotecaAppUI.ReadInteger();
            options.get(read).run();
        }
    }

    public static void TryToReturnBook() {
        BibliotecaAppUI.ReturnBookMessage();
        String bookName = BibliotecaAppUI.ReadBookName();
        //ReturnBook(bookName);
    }

    public static void TryToCheckoutBook() {
        BibliotecaAppUI.CheckoutBookMessage();
        String bookName = BibliotecaAppUI.ReadBookName();
        biblioteca.CheckoutBook(bookName);
    }

    private static void Quit() {
        available = false;
        System.out.println("Goodbye! See you soon!");
    }

    private static void InitializingMenu() {
        options.put(1, () -> BibliotecaAppUI.ListBooks(biblioteca.getBooks()));
        options.put(2, () -> TryToCheckoutBook());
        options.put(3, () -> TryToReturnBook());
        options.put(13, () -> Quit());
    }

}
