package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Book book;
    private Movie movie;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();

        book = new Book("Test", "Tester", 1996);
        biblioteca.AddBook(book);

        movie = new Movie("Test", "Tester", 1996, 0);
        biblioteca.AddMovie(movie);

    }

    @After
    public void tearDown() {
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
    public void FindMovieTestByItsName() throws IOException {
        Movie movie = biblioteca.FindMovieByName("Test");
        assertEquals(this.movie, movie);
    }

    @Test(expected = IOException.class)
    public void FindMovieTest2ByItsNameThrowsException() throws IOException {
        Movie movie = biblioteca.FindMovieByName("Test2");
    }

    @Test
    public void CheckoutBookTest() throws IOException {
        biblioteca.CheckoutBook("Test");
        Assert.assertFalse(book.getAvailable());
    }

    /*@Test
    public void CheckoutMovieTest() {
        biblioteca.CheckoutMovie("Test");
        Assert.assertFalse(movie.getAvailable());
    }*/

    @Test
    public void ReturnBookTest() throws IOException {
        book.setAvailable(false);
        biblioteca.ReturnBook("Test");
        Assert.assertTrue(book.getAvailable());
    }

}