package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Book> books = new ArrayList();

    Biblioteca() {
        InitializingLibraryDatabase();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Boolean CheckoutBook(String bookName) throws IOException {
        try {
            Book book = FindBookByName(bookName);
            if (book.getAvailable()) {
                book.setAvailable(false);
                return true;
            } else
                return false;
        } catch (IOException ex) {
            throw ex;
        }
    }

    public Boolean ReturnBook(String bookName) throws IOException {
        try {
            Book book = FindBookByName(bookName);
            if (!book.getAvailable()) {
                book.setAvailable(true);
                return true;
            } else
                return false;
        } catch (IOException ex) {
            throw ex;
        }
    }

    public Book FindBookByName(String name) throws IOException {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        throw new IOException("We don't have this book.");
    }

    public void AddBook(Book book) {
        books.add(book);
    }

    public void InitializingLibraryDatabase() {
        Book book1 = new Book("Test-Driven Development by example", "Kent Beck", 2000);
        books.add(book1);

        Book book2 = new Book("Extreme Programming Explained", "Kent Beck", 1999);
        books.add(book2);

        Book book3 = new Book("Implementation Patterns", "Kent Beck", 2007);
        books.add(book3);
    }

}
