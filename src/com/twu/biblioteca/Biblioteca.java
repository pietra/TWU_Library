package com.twu.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private static ArrayList<Book> books = new ArrayList();

    public static ArrayList<Book> getBooks() {
        return books;
    }

    Biblioteca() {
        InitializingLibraryDatabase();
    }

    public void CheckoutBook(String bookName) {
        Book book = FindBookByName(bookName);
        if (book.getAvailable()) {
            book.setAvailable(false);
            System.out.println("Congratulation! You checked out " + book.getName() + ".");
        } else
            System.out.println("Oh, no! " + book.getName() + " isn't available.");
    }

    public void ReturnBook(String bookName) {
        Book book = FindBookByName(bookName);
        // TODO
    }

    public void InitializingLibraryDatabase() {
        Book book1 = new Book("Test-Driven Development by example", "Kent Beck", 2000);
        books.add(book1);

        Book book2 = new Book("Extreme Programming Explained", "Kent Beck", 1999);
        books.add(book2);

        Book book3 = new Book("Implementation Patterns", "Kent Beck", 2007);
        books.add(book3);
    }

    private Book FindBookByName(String name) {
        Book bookWanted = new Book();
        for (Book book : books) {
            if (book.getName().equals(name)) {
                bookWanted = book;
                break;
            }
        }
        return bookWanted;
    }

}
