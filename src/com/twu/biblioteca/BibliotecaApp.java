package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaApp {

    public static ArrayList<Book> LibraryDatabase = new ArrayList();
    private static Boolean available = true;
    private static Map<Integer, Runnable> options = new HashMap<>();

    public static void main(String[] args) {
        InitializingLibraryDatabase();
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
        Book book = FindBookByName(bookName);
        //ReturnBook(book);
    }

    public static void TryToCheckoutBook() {
        BibliotecaAppUI.CheckoutBookMessage();
        String bookName = BibliotecaAppUI.ReadBookName();
        Book book = FindBookByName(bookName);
        CheckoutBook(book);
    }

    public static void CheckoutBook(Book book) {
        if (book.getAvailable()) {
            book.setAvailable(false);
            System.out.println("Congratulation! You checked out " + book.getName() + ".");
        } else
            System.out.println("Oh, no! " + book.getName() + " isn't available.");
    }

    private static void Quit() {
        available = false;
        System.out.println("Goodbye! See you soon!");
    }

    public static Book FindBookByName(String name) {
        Book bookWanted = new Book();
        for (Book book : LibraryDatabase) {
            if (book.getName().equals(name)) {
                bookWanted = book;
                break;
            }

        }
        return bookWanted;
    }

    public static void InitializingLibraryDatabase() {
        Book book1 = new Book("Test-Driven Development by example", "Kent Beck", 2000);
        LibraryDatabase.add(book1);

        Book book2 = new Book("Extreme Programming Explained", "Kent Beck", 1999);
        LibraryDatabase.add(book2);

        Book book3 = new Book("Implementation Patterns", "Kent Beck", 2007);
        LibraryDatabase.add(book3);
    }

    private static void InitializingMenu() {
        options.put(1, () -> BibliotecaAppUI.ListBooks(LibraryDatabase));
        options.put(2, () -> TryToCheckoutBook());
        options.put(3, () -> TryToReturnBook());
        options.put(13, () -> Quit());
    }

}
