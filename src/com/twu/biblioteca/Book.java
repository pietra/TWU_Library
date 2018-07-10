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

    Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Boolean getAvailable() { return available; }

    public void setAvailable(Boolean available) { this.available = available; }

}
