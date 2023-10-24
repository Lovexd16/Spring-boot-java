package com.library.library;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BooksController {
    private static final List<Books> bookItems = new ArrayList<>();
    static {
        bookItems.add(new Books("Loves dagbok", "Love", 100, 1));
    }

    @GetMapping("/books")
    String getBooks(Model bookModel) {
        bookModel.addAttribute("bookItems", bookItems);
        bookModel.addAttribute("newBook", new Books(null, null, 0, 0));
        return "books";
    }

    @PostMapping("/new-book")
    String newBook(@RequestParam("bookTitle") String bookTitle, @RequestParam("bookAuthor") String bookAuthor, @RequestParam("bookPages") int bookPages) {
        bookItems.add(new Books(bookTitle, bookAuthor, bookPages, bookItems.size() + 1));
        return "redirect:/books";
    }

    @GetMapping("/remove-bookItem/{bookItemId}")
    String removeBookItem(@PathVariable int bookItemId) {
        bookItems.removeIf(bookItem -> bookItem.getBookId() == bookItemId);
        return "redirect:/books";
    }


}
