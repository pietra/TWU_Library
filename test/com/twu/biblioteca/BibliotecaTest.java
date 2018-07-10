package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    Book book;

    @Before
    public void setUp() throws Exception {
        biblioteca = new Biblioteca();
        book = new Book("Test", "Tester", 1996);
        biblioteca.AddBook(book);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void FindBookTestByItsName() throws IOException {
        Book book = biblioteca.FindBookByName("Test");
        assertEquals(this.book, book);
    }

    @Test(expected = IOException.class)
    public void FindBookTest2ByItsNameThrowsException() throws IOException {
        Book book = biblioteca.FindBookByName("Test2");
    }

    @Test
    public void CheckoutBookTest() throws IOException {
        biblioteca.CheckoutBook("Test");
        Assert.assertFalse(book.getAvailable());
    }

    @Test
    public void ReturnBookTest() throws IOException {
        book.setAvailable(false);
        biblioteca.ReturnBook("Test");
        Assert.assertTrue(book.getAvailable());
    }

}