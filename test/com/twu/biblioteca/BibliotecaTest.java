package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void FindBookTest() {
        Book book = biblioteca.FindBookByName("Test");
        assertEquals(this.book, book);
    }

    @Test//(expected = ClassNotFoundException.class)
    public void FindBookTest2ThrowsException() {
        Book book = biblioteca.FindBookByName("Test2");
    }

    @Test
    public void CheckoutBookTest() {
        biblioteca.CheckoutBook("Test");
        Assert.assertFalse(book.getAvailable());
    }

    @Test
    public void ReturnBookTest() {
        book.setAvailable(false);
        biblioteca.ReturnBook("Test");
        Assert.assertTrue(book.getAvailable());
    }

}