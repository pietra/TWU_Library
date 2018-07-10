package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private int yearPublished;
    private Boolean available;

    Book(String newName, String newAuthor, int newYearPublished) {
        name = newName;
        author = newAuthor;
        yearPublished = newYearPublished;
        available = true;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Boolean getAvailable() { return available; }

    public void setAvailable(Boolean available) { this.available = available; }

}
