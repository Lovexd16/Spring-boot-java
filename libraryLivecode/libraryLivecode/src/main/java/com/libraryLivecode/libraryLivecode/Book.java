package com.libraryLivecode.libraryLivecode;

public class Book {
    private String title;
    private String author;
    private int pages;
    private boolean rented; 

    Book(String title, String author, int pages, boolean rented) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.rented = rented;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented() {
        this.rented = !this.rented;
    }

    
}