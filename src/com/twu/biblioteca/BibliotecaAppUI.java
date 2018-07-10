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

    public static void MenuMessage() {
        System.out.println();
        System.out.println("************ Menu Options ***********");
        System.out.println("            List Books - 1           ");
        System.out.println("          Check out book - 2         ");
        System.out.println("            Return book - 3          ");
        System.out.println("              Quit - 13              ");
        System.out.println("*************************************");
    }

    public static void ListBooksMessage() {
        System.out.println();
        System.out.println("List of books");
    }

    public static void CheckoutBookMessage() {
        System.out.println();
        System.out.println("Do you wanna checkout a book? Type its name: ");
    }

    public static void CheckoutBookSuccess(String bookName) {
        System.out.println();
        System.out.println("Congratulations! You checked out " + bookName + ".");
    }

    public static void CheckoutBookFail(String bookName) {
        System.out.println();
        System.out.println("Oh, no! " + bookName + " isn't available.");
    }

    public static void ReturnBookMessage() {
        System.out.println();
        System.out.println("Do you wanna return a book? Type its name: ");
    }

    public static void ReturnBookSuccess(String bookName) {
        System.out.println();
        System.out.println("Nice! You returned " + bookName + ".");
    }

    public static void ReturnBookFail(String bookName) {
        System.out.println();
        System.out.println("What? " + bookName + " was already available.");
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

}
