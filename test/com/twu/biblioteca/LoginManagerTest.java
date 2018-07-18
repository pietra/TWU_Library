package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class LoginManagerTest {

    LoginManager loginManager;
    Librarian user1;
    Customer user2;
    Address address;

    @Before
    public void setUp() {
        loginManager = new LoginManager();
        user1 = new Librarian("000-0003", "admin");
        address = new Address("Brazil", "RS", "POA", "Av. Ipiranga", "0");
        user2 = new Customer("Pietra", "pietra@pietra.com.br", address, "0800", "000-0004", "user");
        loginManager.AddUsers(user1);
        loginManager.AddUsers(user2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void FindUserByLibraryNumber() throws IOException {
        User user = loginManager.FindUserByLibraryNumber(user1.getLibraryNumber());
        Assert.assertEquals(user1, user);
    }

    @Test(expected = IOException.class)
    public void FindUserByLibraryNumberThrowsException() throws IOException {
        User user = loginManager.FindUserByLibraryNumber("000-0005");
    }

    @Test
    public void LoginWithUser() throws IOException {
        loginManager.Login(user1.getLibraryNumber(), user1.getPassword());
    }

    @Test(expected = IOException.class)
    public void LoginWithUserThrowsException() throws IOException {
        loginManager.Login(user1.getLibraryNumber(), "wrongpassword");
    }

}