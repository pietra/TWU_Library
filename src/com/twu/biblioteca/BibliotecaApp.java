package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private static ArrayList<Book> LibraryDatabase = new ArrayList();
    private static Boolean available = true;

    public static void main(String[] args) {
        InitializingLibraryDatabase();
        WelcomeMessage();
        Menu();
    }

    private static void Menu() {
        while (available) {
            MenuMessage();
            int read = ReadInteger();
            switch (read) {
                case 1: {
                    ListBooks();
                }
                break;
                case 13: {
                    Quit();
                }
                break;
                default: {
                    System.out.println("Ops, option not found.");
                }
                break;
            }
        }

    }

    private static void ListBooks() {
        ListBooksMessage();
        for (Book book : LibraryDatabase) {
            if (book.getAvailable()) {
                System.out.println(book.getName() + " | ");
                System.out.print(book.getAuthor() + " | ");
                System.out.print(book.getYearPublished() + " | ");
            }
        }
    }

    private static void Quit() {
        available = false;
        System.out.println("Goodbye! See you soon!");
    }

    public static int ReadInteger() {
        Scanner number = new Scanner(System.in);
        return number.nextInt();
    }

    private static void WelcomeMessage() {
        System.out.println("*************************************");
        System.out.println("************* Welcome to ************");
        System.out.println("***** Library Management System *****");
        System.out.println("** of The Bangalore Public Library **");
        System.out.println("*************************************");
    }

    private static void MenuMessage() {
        System.out.println();
        System.out.println("************ Menu Options ***********");
        System.out.println("            List Books - 1           ");
        System.out.println("              Quit - 13              ");
        System.out.println("*************************************");
    }

    private static void ListBooksMessage() {
        System.out.println();
        System.out.println("List of books");
    }

    public static void InitializingLibraryDatabase() {
        Book book1 = new Book("Test-Driven Development by example", "Kent Beck", 2000);
        LibraryDatabase.add(book1);

        Book book2 = new Book("Extreme Programming Explained", "Kent Beck", 1999);
        LibraryDatabase.add(book2);

        Book book3 = new Book("Implementation Patterns", "Kent Beck", 2007);
        LibraryDatabase.add(book3);
    }

}
