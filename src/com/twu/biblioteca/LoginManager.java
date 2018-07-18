package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginManager {

    ArrayList<User> users = new ArrayList();
    HashMap<Integer, Runnable> optionsForLibrarian = new HashMap();
    HashMap<Integer, Runnable> optionsForCustomer = new HashMap();

    LoginManager() {
        InitializingUsers();
        InitializingMenu();
    }

    public void AddUsers(User user) {
        users.add(user);
    }

    public HashMap<Integer, Runnable> Login(String libraryNumber, String password) throws IOException {
        User user = FindUserByLibraryNumber(libraryNumber);
        CheckLogin(user.getPassword(), password);

        if (user instanceof Customer)
            return optionsForCustomer;

        return optionsForLibrarian;
    }

    private void CheckLogin(String password, String passwordGiven) throws IOException {
        if (!password.equals(passwordGiven))
            throw new IOException();
    }

    public User FindUserByLibraryNumber(String libraryNumber) throws IOException {
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                return user;
            }
        }
        throw new IOException("This user doesn't exist.");
    }

    private void InitializingMenu() {
        optionsForCustomer.put(2, BibliotecaApp::ListBooks);
        optionsForCustomer.put(3, BibliotecaApp::TryToCheckoutBook);
        optionsForCustomer.put(4, BibliotecaApp::TryToReturnBook);
        optionsForCustomer.put(5, BibliotecaApp::ListMovies);
        optionsForCustomer.put(6, BibliotecaApp::TryToCheckoutMovie);
        optionsForCustomer.put(7, BibliotecaApp::TryToReturnMovie);
        optionsForLibrarian.put(1, BibliotecaApp::ListBooksCheckedOut);
    }

    private void InitializingUsers() {
        Librarian user1 = new Librarian("000-0001", "admin");

        Address addressUser2 = new Address("Brazil", "RS", "POA", "Av. Ipiranga", "0");
        Customer user2 = new Customer("Pietra", "pietra@pietra.com.br", addressUser2, "0800", "000-0002", "user");

        AddUsers(user1);
        AddUsers(user2);

    }

}
