package com.twu.biblioteca;

import java.util.HashMap;

public class Librarian extends User {

    public HashMap<Integer, Runnable> options = new HashMap<>();

    Librarian(String libraryNumber, String password) {
        super(libraryNumber, password);
        InitializingMenu();
    }

    public HashMap<Integer, Runnable> getOptions() {
        return options;
    }

    private void InitializingMenu() {
        options.put(1, BibliotecaApp::ListBooksCheckedOut);
    }

}
