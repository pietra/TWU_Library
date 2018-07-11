package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class LoginManager {

    ArrayList<User> users = new ArrayList();

    LoginManager() {
        InitializingUsers();
    }

    public void AddUsers(User user) {
        users.add(user);
    }

    public User FindUserByLibraryNumber(String libraryNumber) throws IOException {
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                return user;
            }
        }
        throw new IOException("This user doesn't exist.");
    }

    private void InitializingUsers() {
        Librarian user1 = new Librarian("000-0001", "admin");

        Address addressUser2 = new Address("Brazil", "RS", "POA", "Av. Ipiranga", "0");
        Customer user2 = new Customer("Pietra", "pietra@pietra.com.br", addressUser2, "0800", "000-0002", "user");

        AddUsers(user1);
        AddUsers(user2);

    }

}
