package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private static ArrayList<Book> LibraryDatabase = new ArrayList();

    @Before
    public void setUp() throws Exception {
        BibliotecaApp.InitializingLibraryDatabase();
    }

    @After
    public void tearDown() throws Exception {
    }
    
}