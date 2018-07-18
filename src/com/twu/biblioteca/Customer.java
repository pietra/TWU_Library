package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends User {

    private String name;
    private String email;
    private Address address;
    private String phoneNumber;
    public HashMap<Integer, Runnable> options = new HashMap<>();

    public Customer(String name, String email, Address address, String phoneNumber, String libraryNumber, String password) {
        super(libraryNumber, password);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        InitializingMenu();
    }

    public HashMap<Integer, Runnable> getOptions() {
        return options;
    }

    private void InitializingMenu() {
        options.put(1, BibliotecaApp::ListBooks);
        options.put(2, BibliotecaApp::TryToCheckoutBook);
        options.put(3, BibliotecaApp::TryToReturnBook);
        options.put(4, BibliotecaApp::ListMovies);
        options.put(5, BibliotecaApp::TryToCheckoutMovie);
        options.put(6, BibliotecaApp::TryToReturnMovie);
    }

}
