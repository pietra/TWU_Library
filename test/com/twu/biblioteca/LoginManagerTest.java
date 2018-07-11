package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LoginManagerTest {

    LoginManager loginManager;
    Librarian user1;

    @Before
    public void setUp() {
        loginManager = new LoginManager();
        user1 = new Librarian("000-0003", "admin");
        loginManager.AddUsers(user1);
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
        User user = loginManager.FindUserByLibraryNumber("000-0004");
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