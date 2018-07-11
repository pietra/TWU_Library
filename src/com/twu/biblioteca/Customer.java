package com.twu.biblioteca;

import java.util.ArrayList;

public class Customer extends User {

    private String name;
    private String email;
    private Address address;
    private String phoneNumber;
    private ArrayList<Book> checkedoutBooks;
    private ArrayList<Movie> checkedoutMovies;

    public Customer(String name, String email, Address address, String phoneNumber, String libraryNumber, String password) {
        super(libraryNumber, password);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void AddBookToCheckedoutBooksList(Book book) {
        checkedoutBooks.add(book);
    }

    public void AddMovieToCheckedoutMoviesList(Movie movie) {
        checkedoutMovies.add(movie);
    }

}
