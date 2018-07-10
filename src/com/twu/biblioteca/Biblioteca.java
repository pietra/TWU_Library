package com.twu.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    Biblioteca() {
        InitializingLibraryDatabase();
    }

    private ArrayList<Book> books = new ArrayList();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Boolean CheckoutBook(String bookName) {
        Book book = FindBookByName(bookName);
        if (book.getAvailable()) {
            book.setAvailable(false);
            return true;
        } else
            return false;
    }

    public Boolean ReturnBook(String bookName) {
        Book book = FindBookByName(bookName);
        if (!book.getAvailable()) {
            book.setAvailable(true);
            return true;
        } else
            return false;
    }

    public void InitializingLibraryDatabase() {
        Book book1 = new Book("Test-Driven Development by example", "Kent Beck", 2000);
        books.add(book1);

        Book book2 = new Book("Extreme Programming Explained", "Kent Beck", 1999);
        books.add(book2);

        Book book3 = new Book("Implementation Patterns", "Kent Beck", 2007);
        books.add(book3);
    }

    public Book FindBookByName(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public void AddBook(Book book) {
        books.add(book);
    }

}
