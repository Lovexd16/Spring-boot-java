package com.libraryLivecode.libraryLivecode;

import java.util.ArrayList;

public class Library {
    public String libraryName;
    ArrayList<Book> books;

    Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, int pages, boolean rented) {
        books.add(new Book(title, author, pages, rented));
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    
}
