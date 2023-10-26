package com.libraryLivecode.libraryLivecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {
    
    @GetMapping("/book/{bookTitle}")
    String getBook(@PathVariable String bookTitle, Model model) {
        System.out.println("bookTitle: " + bookTitle);

        for (Book book : LibraryLivecodeApplication.library.books) {
            if (book.getTitle().equals(bookTitle)) {
                //model.addAttribute("title", book.getTitle());
                //model.addAttribute("author", book.getAuthor());
               model.addAttribute("book", new Book(book.getTitle(), book.getAuthor(), book.getPages(), book.isRented()));
                return "book"; 
            }
        }

        return "book";
    }

    @GetMapping("/book/rent/{bookTitle}")
    String getRent(@PathVariable String bookTitle, Model model) {
        System.out.println("bookTitle: " + bookTitle);

        for (Book book : LibraryLivecodeApplication.library.books) {
            if (book.getTitle().equals(bookTitle)) {
                book.setRented();

                //model.addAttribute("title", book.getTitle());
                //model.addAttribute("author", book.getAuthor());
               model.addAttribute("book", new Book(book.getTitle(), book.getAuthor(), book.getPages(), book.isRented()));
                return "book"; 
            }
        }

        return "book";
    }
}