package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private Book book = new Book("Test", "Someone", 1996);

    @Before
    public void setUp() throws Exception {
        BibliotecaApp.InitializingLibraryDatabase();
        BibliotecaApp.LibraryDatabase.add(book);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void FindTestBook() {
        Assert.assertEquals(book, BibliotecaApp.FindBookByName(book.getName()));
    }

    @Test
    public void CheckoutTestBook() {
        Assert.assertTrue(book.getAvailable());
        BibliotecaApp.CheckoutBook(book);
        Assert.assertFalse(book.getAvailable());
    }

}